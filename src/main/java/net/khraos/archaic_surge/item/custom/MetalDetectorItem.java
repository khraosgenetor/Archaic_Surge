package net.khraos.archaic_surge.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {

        if(pContext.getLevel().isClientSide()) {
            BlockPos posClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= posClicked.getY() + 64; i++) {
                BlockState bs = pContext.getLevel().getBlockState(posClicked.below(i));

                if (isValuableBlock(bs)) {
                    assert player != null;
                    outputValuableCoordinates(posClicked.below(i), player, bs.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                assert player != null;
                player.sendSystemMessage(Component.literal("No valuable ore found nearby!"));
            }

        }

        return InteractionResult.SUCCESS;
    }

    private void outputValuableCoordinates(BlockPos BP, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found "+ I18n.get(block.getDescriptionId() + " at " +
                "(" + BP.getX() + " " + BP.getY() + " " + BP.getZ() + ")")));
    }

    private boolean isValuableBlock(BlockState state){
        return state.is(Blocks.IRON_ORE);
    }
}