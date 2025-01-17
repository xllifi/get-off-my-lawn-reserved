package draylar.goml.registry;

import draylar.goml.GetOffMyLawn;
import draylar.goml.block.ClaimAnchorBlock;
import draylar.goml.item.GogglesItem;
import draylar.goml.item.UpgradeKitItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class GOMLItems {
    public static List<Item> BASE_ITEMS = new ArrayList<>();

    public static final Item REINFORCED_UPGRADE_KIT = registerUpgradeKit("reinforced_upgrade_kit", GOMLBlocks.MAKESHIFT_CLAIM_ANCHOR.getFirst(), GOMLBlocks.REINFORCED_CLAIM_ANCHOR.getFirst(), Items.IRON_INGOT);
    public static final Item GLISTENING_UPGRADE_KIT = registerUpgradeKit("glistening_upgrade_kit", GOMLBlocks.REINFORCED_CLAIM_ANCHOR.getFirst(), GOMLBlocks.GLISTENING_CLAIM_ANCHOR.getFirst(), Items.GOLD_INGOT);
    public static final Item CRYSTAL_UPGRADE_KIT = registerUpgradeKit("crystal_upgrade_kit", GOMLBlocks.GLISTENING_CLAIM_ANCHOR.getFirst(), GOMLBlocks.CRYSTAL_CLAIM_ANCHOR.getFirst(), Items.DIAMOND);
    public static final Item EMERADIC_UPGRADE_KIT = registerUpgradeKit("emeradic_upgrade_kit", GOMLBlocks.CRYSTAL_CLAIM_ANCHOR.getFirst(), GOMLBlocks.EMERADIC_CLAIM_ANCHOR.getFirst(), Items.EMERALD);
    public static final Item WITHERED_UPGRADE_KIT = registerUpgradeKit("withered_upgrade_kit", GOMLBlocks.EMERADIC_CLAIM_ANCHOR.getFirst(), GOMLBlocks.WITHERED_CLAIM_ANCHOR.getFirst(), Items.NETHER_STAR);

    public static final Item GOGGLES = register("goggles", new GogglesItem());

    private static UpgradeKitItem registerUpgradeKit(String name, ClaimAnchorBlock from, ClaimAnchorBlock to, Item item) {
        return register(name, new UpgradeKitItem(from, to, item));
    }

    private static <T extends Item> T register(String name, T item) {
        BASE_ITEMS.add(item);
        return Registry.register(Registries.ITEM, GetOffMyLawn.id(name), item);
    }

    public static void init() {
        // NO-OP
    }

    private GOMLItems() {
        // NO-OP
    }
}
