package com.github.hodongwook.towny.core.api.region.adapter;

import com.github.hodongwook.towny.core.api.region.Region;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public interface CommandExecutable {

    /**
     * 서브 커맨드
     * @return 서브 커맨드
     */
    String getCommand();
    default String[] getAlias() { return new String[] {}; }

    /**
     * 해당 명령어에 대한 설명
     * @return 설명
     */
    @NotNull
    default String getDescription() { return ""; }

    /**
     * 해당 명령어의 사용법
     * @return 사용법
     */
    @NotNull default String getUsage() { return ""; }

    /**
     * 해당 명령어가 도움말로 출력될 때 우선순위
     * 숫자가 클수록 뒤에 배치됩니다.
     * @default 0
     * @return 우선순위
     */
    default int getPriority() { return 0; }

    /**
     * 해당 명령어가 마을 보유 여부에 따른 활성화 여부를 가집니다.
     * 마을이 있을 경우에 활성화 하고 싶은경우
     * region != null 의 값을 리턴하세요
     * @param region 마을
     * @return 활성화 여부
     */
    default boolean isEnabled(Region region) { return true; }

    /**
     * 플레이어가 해당 명령어를 입력했을 때, 호출되는 메서드입니다.
     * @param sender 플레이어
     * @param region 마을
     * @param label 메인 커맨드
     * @param args 서브 커맨드 이 후의 argument
     */
    void execute(Player sender, Region region, String label, String[] args);
    default void executeConsole(CommandSender sender, String label, String[] args) {}
    default List<String> tabComplete(CommandSender sender, String label, Region region, String[] args) {
        return Collections.emptyList();
    }

}
