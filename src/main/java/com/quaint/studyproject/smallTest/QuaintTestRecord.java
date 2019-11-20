package com.quaint.studyproject.smallTest;


/**
 * @Description: String 调试测试
 * @author: qicong
 * @Date: Created in 2019/9/19 11:28
 * @Version: 1.0
 */
public class QuaintTestRecord {


    public static void main(String[] args) {

        // -------------------------定义函数记录类-----------------------------
        QuaintFunRecord quaintFun = new QuaintFunRecord();
        // ----------------------------end----------------------------------



//        // 测试 json 转换
//        String json = "{'code':0,'message':'请求成功','data':{'id':null,'name':'admin2_cswb','realName':'','email':'','cardNo':null}}";
//        JSONObject jsonObject = JSONObject.parseObject(json);
//        // 可能存在空指针异常
//        JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString("data"));
//        System.out.println(jsonObject1.getString("name"));
//
//        // 等价于  可能存在空指针异常
//        System.out.println(jsonObject.getJSONObject("data").getString("name"));


//        // 生成对应 映射
//        Map<String, Integer> shopCodeIdMapping = new HashMap<>();
//        Map<String, Integer> shopNameIdMapping = new HashMap<>();
//        Map<Integer, String> shopIdIconMapping = new HashMap<>();
//        shopCodeIdMapping.put("1234", 1);
//        shopIdIconMapping.put(1, "1345646");
//        shopNameIdMapping.put("name", 2);
//        Integer shopId = Objects.isNull(shopCodeIdMapping.get("123"))
//                ?shopNameIdMapping.get("name")
//                :shopCodeIdMapping.get("123");
//        System.out.println(shopId);

//        // 测试 时间比较
//        if (LocalDateTime.now().compareTo(LocalDateTime.parse("2019-11-19T00:00:00"))>0)
//            System.out.println("活动结束");
//        if (LocalDateTime.now().compareTo(LocalDateTime.parse("2019-11-19T00:00:00"))<0)
//            System.out.println("活动未结束");


//        // 测试  方法修改引用对象 String
//        List<String> list = Arrays.asList("123","456");
//        for (String s : list) {
//            quaintFun.listModify(s);
//            System.out.println(s);
//        }

//        // --quaint1017 【测试 回调函数】 (Be used for [ctrl+h])
//        quaintFun.testFun(true,
//                (a)-> System.out.println(a),
//                //System.out::println,
//                ()-> System.out.println("fail"));


//        // HashMap put  返回值 测试
//        Map<String, Integer> shopNameIdMapping = new HashMap<>();
//        System.out.println(shopNameIdMapping.put("test",1));    // null
//        System.out.println(shopNameIdMapping.put("test2",2));   // null
//        System.out.println(shopNameIdMapping.put("test2",2));   // 2
//        System.out.println(shopNameIdMapping.put("test2",3));   // 2
//        System.out.println(shopNameIdMapping.put("test3",1));   // null
//
//        BiConsumer<String,Integer> biConsumer = (s, integer) -> {
//            System.out.println("key: "+s);
//            System.out.println("val: "+integer);
//        };
//        shopNameIdMapping.forEach(biConsumer);

//        // 四舍五入 测试
//        BigDecimal bigDecimal = new BigDecimal(2.6);
//        System.out.println(bigDecimal.add(new BigDecimal(0.5)).intValue());
//
//        BigDecimal bigDecimal2 = new BigDecimal(-2.6).setScale(0, RoundingMode.HALF_UP);
//        System.out.println(bigDecimal2.intValue());

//        // 异常打印测试
//        try {
//            int a = 3/0;
//        } catch (Exception e) {
//            System.out.println(e.fillInStackTrace());
//            System.out.println(e.getMessage());
//            System.out.println(e.getLocalizedMessage());
//        }


//        // 打印出map的key     2019/10/22
//        Map map = new HashMap();
//        map.put("test1",5L);
//        System.out.println(map.keySet().toArray()[0]);


//        // 获取每月的 第一天和最后一天  2019/10/18
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime startTime = now.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0).withSecond(0);
//        LocalDateTime endTime = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23).withMinute(59).withSecond(59);
//        System.out.println(startTime);
//        System.out.println(endTime);


//        // 测试 BigDecimal 的比较方法   2019/10/17
//        BigDecimal bigDecimal = new BigDecimal(1).multiply(new BigDecimal(0.05));
//        System.out.println(bigDecimal);
//        System.out.println(BigDecimal.ZERO.equals(bigDecimal));
//        System.out.println("0.00".equals(bigDecimal.toString()));
//        System.out.println(BigDecimal.ZERO.compareTo(bigDecimal));
//        System.out.println(new BigDecimal("1.0").compareTo(BigDecimal.ZERO));


//        // LocalDateTime 与字符串转换测试  2019/10/17
//        System.out.println(LocalDateTime.parse("2017-11-11T11:11:00"));
//        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println(LocalDateTime.parse("2017-11-11 11:11:11",df));
//        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.println(LocalDate.parse("2017-11-11"));
//        System.out.println(LocalDate.parse("2017-11-11",df2).atTime(0,0,0));
//        System.out.println(LocalDate.parse("2017-11-11",df2).atTime(23,59,59));
//        System.out.println(LocalDateTime.now().toString().replace('T',' '));
//        System.out.println(LocalDateTime.now().withHour(0).withMinute(0).withSecond(0));


//        // float 类型精度问题 2019/10/17
//        Float confirmedRefundMoney = 0.7f;
//        int refundRemainderInCent = 70;
//        String wx = String.format("%.2f",Math.abs(confirmedRefundMoney - refundRemainderInCent/100.0));
//        String wx2 = String.format("%.2f",confirmedRefundMoney - refundRemainderInCent/100.0);
//        System.out.println(wx+"  "+wx2);

    }

}
