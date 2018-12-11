package com.dqkj.sam;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Dfs {
    private JdbcTemplate jdbcTemplate;

    private void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.95.13.93:3306/likestext?serverTimezone=GMT%2B8");
        dataSource.setUsername("zzdqadmin");
        dataSource.setPassword("zzdq123456");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void creatNewData() {

        init();

        String maxid = jdbcTemplate.queryForObject("select max(id) from person;", String.class);
        if (maxid.equals("") || maxid == null) {
            maxid = "0";
        }
        int maxidd = Convert.toInt(maxid);
        for (int a = maxidd + 1; a < maxidd + 1 + 1499; a++) {
            int page = RandomUtil.randomInt(10, 40);
            int zz = RandomUtil.randomInt(0, 3);
            String penname = RandomUtil.randomString("阳光佳美好浩然乾坤正义山有木兮木有枝心悦君兮君不知人间四月芳菲尽大风起兮云" +
                    "飞扬梨花风起正清明游子寻春半出城花间一壶酒独酌无相亲举杯邀明月对影成三人月既不解饮影徒随我身暂伴月将影行乐须及春我歌月徘徊" +
                    "我舞影零乱醒时同交欢醉后各分散永结无情游相期邈云薄雾浓云愁永昼瑞脑消金兽佳节又重阳玉枕纱厨半夜凉初透东篱把酒黄昏后有暗香盈" +
                    "袖莫道不消魂帘卷西风人比黄花瘦西风独自凉萧萧黄叶闭疏窗沉思往事立残阳被酒莫惊春睡重赌书消得泼茶香当时只道是寻常茶香当时只道是" +
                    "日暮笙歌收拾去万株杨柳属流莺谁念西风独自凉萧萧黄叶闭疏窗沉思往事立残阳被酒莫惊春睡重赌书消得泼寻常", zz);
            String pennamex = RandomUtil.randomString("张王李赵钱孙马蒋沈韩杨奚范彭郎俞任袁柳朱秦尤许那简饶空曾毋沙乜养鞠须丰" +
                    "巢关蒯相查後荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲" +
                    "孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓跋夹谷宰父谷梁晋楚闫法汝鄢" +
                    "涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福", 1);
            String uuid = RandomUtil.simpleUUID();

            String sql = "insert into person(id,name,age,description)values(" + a + ",'" + pennamex + penname + "','" + page + "','" + uuid + "');";
            Console.log(a);
            jdbcTemplate.execute(sql);
        }


    }


}
