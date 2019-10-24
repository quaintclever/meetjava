package com.quaint.studyproject.demoTest.mihoyo;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName: MiHoYo
 * @Description:
 * @date: 2019-10-24 21:22
 * @author: quaint
 * @version:
 * @since: JDK 1.8
 */
public class MiHoYo1024 {

    // 大伟哥 员工专属id
    private static final Long BIG_WEI_MEMBER_ID = 1L;
    // 内推奖励，外部员工未知
    private static final Integer NEI_TUI_AWARD_MONEY = Integer.MAX_VALUE;

    // 简历
    public static final class Resume{

        public String position = "java"; // 投递职位

        public Long neiTuiMemberId = 777L; //内推员工id

        public LocalDateTime neiTuiTimestamp = LocalDateTime.now(); //内推时间戳，内推时间

    }

    // mihoyo 会员
    //@Data
    public static final class MiHoYoMember{

        private int memberId = 0;   // 内推者对外 保密 id

        private int money = 0;    // 内推成功的奖励？ 对外私有？

        private Resume resumePtr; // cpp的对象指针会加Ptr ，这里代表内推的简历

        /**
         * 获取内推的员工id
         * @return
         */
        public int getMemberId() {
            return memberId;
        }

        /**
         * 员工内推成功，增加money  你懂的
         * @param money
         */
        public void addMoney(int money) {
            this.money = this.money+money;
        }

        /**
         * 查看推荐人的简历
         * @return
         */
        public Resume getResumePtr() {
            return resumePtr;
        }

        /**
         * 福利1，每天免费晚餐
         * @return
         */
        boolean canFreeDinnerEveryDay(){
            return true;
        }

        /**
         * 福利2，每月团建
         * @return
         */
        boolean canTeamBuildingEveryMonth(){
            return true;
        }

        /**
         * 福利3，每年出国旅游
         * @return
         */
        boolean canFreeOverSeaTripEveryYear(){
            return true;
        }

        /**
         * 共同的梦想：技术宅拯救世界！
         * @return
         */
        boolean canSaveTheWorldByTechnology(){
            return true;
        }

        /**
         * 大伟哥内推，你懂的~
         * @return
         */
        boolean isBigWei(){
            return this.memberId == BIG_WEI_MEMBER_ID;
        }

        /**
         * 拆别墅，大伟哥决定
         * @return
         */
        boolean sellHouse(){
            return isBigWei();
        }

    }


    private static final class MiHoYo{

        // 员工集合
        private Map<Integer,MiHoYoMember> memberMap;

        // 员工对象
        private MiHoYoMember miHoYoMember;

        // 公司资金
        private int money;

        /**
         * 增加一个新员工
         * @param miHoYoMember 米哈游内部员工
         */
        public void addNewMember(MiHoYoMember miHoYoMember){
            // Thanks the 1024
            // 简历投递
            Resume resume = miHoYoMember.getResumePtr();
            if (!Objects.isNull(resume) && miHoYoMember.getMemberId()!=0){
                int awardMoney = NEI_TUI_AWARD_MONEY;

                // 内推时间内， 内推职位奖励*4
                if (LocalDateTime.parse("2019-10-24 00:00:00").compareTo(resume.neiTuiTimestamp) <= 0
                        && resume.neiTuiTimestamp.compareTo(LocalDateTime.parse("2019-11-04 00:00:00")) <= 0){
                    List<String> positionList = Arrays.asList("客户端开发","服务器开发","引擎开发","渲染开发"
                            ,"技术美术（技术向）","音频程序","数据开发");
                    if (positionList.contains(resume.position)){
                        awardMoney *= 4;
                    }
                }
                addMoneyToMember(resume.neiTuiMemberId,awardMoney);

            }

            // welcome to miHoYo
            memberMap.put(miHoYoMember.getMemberId(),miHoYoMember);

            // 福利发放
            miHoYoMember.canFreeDinnerEveryDay();
            miHoYoMember.canFreeOverSeaTripEveryYear();
            miHoYoMember.canSaveTheWorldByTechnology();
            miHoYoMember.canTeamBuildingEveryMonth();

        }

        /**
         * 员工内推奖励
         * @param memberId
         * @param addMoney
         */
        public void addMoneyToMember(Long memberId, Integer addMoney){

            // 如果金额不够，拆别墅
            while (money<addMoney){
                memberMap.get(1).sellHouse();
            }

        }

    }

}
