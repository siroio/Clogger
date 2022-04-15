package com.github.siroio.commandlog.clogger.FileExport;

import com.github.siroio.commandlog.clogger.Beans.CommandBean;
import com.github.siroio.commandlog.clogger.Beans.PlayerBean;
import com.github.siroio.commandlog.clogger.Utils.DateGetter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Export {

    private final String FolderPath;
    private final String FileName;
    private final PlayerBean[] players;

    public Export(String FolderPath, PlayerBean[] players) {
        this.FolderPath = FolderPath;
        this.players = players;
        FileName = DateGetter.now() +  " PlayerCommandList.txt";
    }

    // プレイヤーの実行されたコマンドをテキストに出力
    public void  toTextFile() {
        Path FilaPath = Paths.get(FolderPath + FileName);
        try(BufferedWriter writer = Files.newBufferedWriter(FilaPath)) {
            for (String str : CommandString()) {
                writer.write(str);
                writer.newLine();
            }
        }
        catch (IOException error) {
            System.out.println("ファイルを出力時にエラーが発生しました。エラーは以下のメッセージを参照してください。\r\n");
            System.out.println(error.getMessage());
        }
    }

    private List<String> CommandString() {
        List<String> list = new ArrayList<>();
        // ビーンすべてを文字列リストへ変換
        for(PlayerBean player : players) {

            list.add("実行プレイヤー:  " + player.getName());

            for (CommandBean cmd : player.getCommandList()) {
                list.add("実行コマンド:  " + cmd.getCommand());
                list.add("実行時間:  " + cmd.getDate());
                list.add("実行座標:  " + cmd.getLocation().getX() + " "
                                      + cmd.getLocation().getY() + " "
                                      + cmd.getLocation().getZ());
            }

            list.add(System.lineSeparator());
        }

        return list;
    }
}
