/*
 * File: VitalTrashCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2023 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitaltrash.commands;

import dev.meinel.leo.vitaltrash.utils.commands.Cmd;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class VitalTrashCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String label, @NotNull String[] args) {
        if (Cmd.isArgsLengthNotEqualTo(sender, args, 0)) {
            return false;
        }
        doTrash(sender);
        return true;
    }

    private void doTrash(@NotNull CommandSender sender) {
        if (Cmd.isInvalidSender(sender) || Cmd.isNotPermitted(sender, "vitaltrash.trash")) {
            return;
        }
        Player senderPlayer = (Player) sender;
        Inventory inventory = Bukkit.createInventory(senderPlayer, 54, Component.text("Trash"));
        senderPlayer.openInventory(inventory);
    }
}
