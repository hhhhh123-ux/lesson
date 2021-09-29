package utils;


/**
 * ID生成器工具类
 *
 * @author ruoyi
 */
public class IdUtils
{
    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID()
    {
        return UUID.randomUUID().toString();
    }


    /**
     * 获取随机5位数UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID5()
    {
        int rand = (int) ((Math.random() * 9 + 1) * 10000);
//        String UUID5=DateUtils.getYear()+rand;
        String string=String.valueOf(rand);
        return string;
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID()
    {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID()
    {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID()
    {
        return UUID.fastUUID().toString(true);
    }
}

