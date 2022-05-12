package com.ynw.oa.project.service.workTime;

import com.ynw.oa.common.utils.DateUtils;
import com.ynw.oa.common.utils.StringUtils;
import com.ynw.oa.project.po.Attend;
import com.ynw.oa.project.po.WorkTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 俞能武
 * 用于打卡时间的日期比对
 */
public class WorkTimeUtils{
    public static long TimeFormatLong(Date date)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);
        String str2 = str.substring(11,13)+str.substring(14,16)+str.substring(17,19);
        long time = Long.valueOf(str2);
        return time;
    }

    /**
     * 获取早上班时间
     */
    public static long MorWorkStartTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getWorkStartTimeMor());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getWorkStartTimeMor()));
    }

    /**
     * 早上下班时间
     */
    public static long MorWorkEndTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getWorkEndTimeMor());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getWorkEndTimeMor()));
    }


    /**
     * 早上打卡开始时间
     */
    public static long attendStartMorTime(Date date, WorkTime workTime)
    {
        /*Date attendStartMorTime = workTime.getAttendMorStartTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(attendStartMorTime);
        String str2 = str.substring(11,13)+str.substring(14,16)+str.substring(17,19);
        long attendStartMorTime2 = Long.valueOf(str2);
        return attendStartMorTime2;*/
        return TimeFormatLong(workTime.getAttendMorStartTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendMorStartTime()));
    }

    /**
     * 早上打卡结束时间
     */
    public static long attendEndMorTime(Date date, WorkTime workTime)
    {
        /*Date attendMorendTime = workTime.getAttendMorendTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(attendMorendTime);
        String str2 = str.substring(11,13)+str.substring(14,16)+str.substring(17,19);
        long attendMorendTime2 = Long.valueOf(str2);*/
        return TimeFormatLong(workTime.getAttendMorendTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendMorendTime()));
    }

    /**
     * 早上下班打卡开始时间
     */
    public static long leaveMorStartTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendMorLeaveStartTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendMorLeaveStartTime()));
    }


    /**
     * 早上下班打卡时间
     */
    public static long leaveMorEnddate(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendMorLeaveEndTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendMorLeaveEndTime()));
    }


    /**
     * 下午上班打卡开始时间
     */
    public static long attendAfterNoonStatrTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendAfterNoonStartTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendAfterNoonStartTime()));
    }

    /**
     * 下午上班打卡结束时间
     */
    public static long attendAfterNoonEndTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendAfterNoonendTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendAfterNoonendTime()));
    }


    /**
     * 下午上班时间
     */
    public static long AfterNoonStarWorkTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getWorkStartTimeAfterNoon());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getWorkStartTimeAfterNoon()));

    }

    /**
     * 下午上班 结束时间
     */
    public static long AfterNonEndWorkTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getWorkEndTimeAfterNoon());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getWorkEndTimeAfterNoon()));
    }


    /**
     * 下午下班结束开始打卡时间
     */
    public static long AttendAfterNoonLeaveStartTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendAfterLeaveStartTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendAfterLeaveStartTime()));
    }

    /**
     * 下午下班班结结束打卡时间
     */
    public static long AttendAfterNoonLeaveEndTime(Date date, WorkTime workTime)
    {
        return TimeFormatLong(workTime.getAttendAfterLeaveEndTime());
        //return dateFormat(date, DateUtils.getTimeShort(workTime.getAttendAfterLeaveEndTime()));
    }


    /**
     * 日期格式转换 将 HH:mm:ss 拼接成 yyyy-MM-dd HH:mm:ss 再转换成时间戳
     *
     * @param strDate 字符窜
     */
    private static long dateFormat(Date date, String strDate)
    {
        long time = 0;

        //获取当前日期
        String s = DateUtils.DateToSTr2(date) + " ";
        String dateStr = s + strDate;
        time = DateUtils.StrToDate(dateStr).getTime();


        return time;
    }


    /**
     * 计算当天考勤的打卡时间差
     */
    public static Map<String, Long> getCurrentAttendTime(WorkTime workShif, Attend attend)
    {
        Map<String, Long> map = new HashMap<>();

        //计算早上上班打卡是否有差异 两个时间在数据库都是time类型 年 月 日 都一样
        Long workStartTime = workShif.getWorkStartTimeMor().getTime();
        if (!StringUtils.isNull(attend.getAttendMorStart()))
        {
            Long attendMorStart = attend.getAttendMorStart().getTime();

            //计算早上打卡时间和上班时间差
            Long timeRang = DateUtils.getTimeRang(workStartTime, attendMorStart);
            map.put("morStart", timeRang);
        }

        //计算早上下班打卡
        Long workEndTime = workShif.getWorkEndTimeMor().getTime();
        map.put("morleave", null);
        if (!StringUtils.isNull(attend.getAttendMorLeave()))
        {
            Long attendMorLeave = attend.getAttendMorLeave().getTime();

            // 大于0 说明 早退
            Long timeRang = DateUtils.getTimeRang(attendMorLeave, workEndTime);
            map.put("morleave", timeRang);
        }


        //计算下午上班打卡
        Long workNoonStartTime = workShif.getWorkStartTimeAfterNoon().getTime();
        map.put("noonStart", null);
        if (!StringUtils.isNull(attend.getAttendNoonStart()))
        {
            Long attendNoonStart = attend.getAttendNoonStart().getTime();

            Long timeRang = DateUtils.getTimeRang(workNoonStartTime, attendNoonStart);
            map.put("noonStart", timeRang);
        }

        //计算下午下班打卡
        Long workNoonEndTime = workShif.getWorkEndTimeAfterNoon().getTime();
        map.put("noonleave", null);
        if (!StringUtils.isNull(attend.getAttendNoonLeave()))
        {
            // 大于0 说明 早退
            Long attendNoonleave = attend.getAttendNoonLeave().getTime();
            Long timeRang = DateUtils.getTimeRang(attendNoonleave, workNoonEndTime);
            map.put("noonleave", timeRang);
        }
        return map;
    }

}
