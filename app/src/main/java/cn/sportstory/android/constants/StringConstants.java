package cn.sportstory.android.constants;

/**
 * Created by aaron on 2017/6/19.
 */

public class StringConstants {
    public static final String[] sports = {};
    public static final String[] sportLevels = {"等级一", "等级二", "等级三", "等级四", "等级五"};
//    public static final String[]
public static final String[] cities = {"北京市", "上海市", "重庆市", "天津市", "香港", "澳门",
        " 河北","石家庄市","唐山市","保定市","邯郸市","邢台市","沧州市","秦皇岛市","张家口市","衡水市","廊坊市","承德市",
        " 山西", "太原市","大同市","运城市","长治市","晋城市","忻州市","临汾市","吕梁市","晋中市","阳泉市","朔州市",
        " 辽宁","大连市","沈阳市","丹东市","辽阳市","葫芦岛市","锦州市","朝阳市","营口市","鞍山市","抚顺市","阜新市","盘锦市","本溪市","铁岭市",
        " 吉林","吉林市","长春市","白山市","延边州","白城市","松原市","辽源市","通化市","四平市",
        " 黑龙江", "齐齐哈尔市","哈尔滨市","大庆市","佳木斯市","双鸭山市","牡丹江市","鸡西市","黑河市","绥化市","鹤岗市","伊春市","大兴安岭地区","七台河市",
        " 江苏", "苏州市","徐州市","盐城市","无锡市","南京市","南通市","连云港市","常州市","镇江市","扬州市","淮安市","泰州市","宿迁市",
        " 浙江", "温州市","宁波市","杭州市","台州市","嘉兴市","金华市","湖州市","绍兴市","舟山市","丽水市","衢州市",
        " 安徽","芜湖市","合肥市","六安市","宿州市","阜阳市","安庆市","马鞍山市","蚌埠市","淮北市","淮南市","宣城市","黄山市","铜陵市","亳州市","池州市","巢湖市","滁州市",
        " 福建","漳州市","厦门市","泉州市","福州市","莆田市","宁德市","三明市","南平市","龙岩市",
        " 江西", "南昌市","赣州市","上饶市","吉安市","九江市","新余市","抚州市","宜春市","景德镇市","萍乡市","鹰潭市",
        " 山东", "济南市","青岛市","临沂市","济宁市","菏泽市","烟台市","淄博市","泰安市","潍坊市","日照市","威海市","滨州市","东营市","聊城市","德州市","莱芜市","枣庄市",
        " 河南", "郑州市","南阳市","新乡市","安阳市","洛阳市","信阳市","平顶山市","周口市","商丘市","开封市","焦作市","驻马店市","濮阳市","三门峡市","漯河市","许昌市","鹤壁市","济源市",
        " 湖北", "武汉市","宜昌市","襄樊市","荆州市","恩施州","黄冈市","孝感市","十堰市","咸宁市","黄石市","仙桃市","天门市","随州市","荆门市","潜江市","鄂州市","神农架林区",
        " 湖南", "长沙市","邵阳市","常德市","衡阳市","株洲市","湘潭市","永州市","岳阳市","怀化市","郴州市","娄底市","益阳市","张家界市","湘西州",
        " 广东", "东莞市","广州市","中山市","深圳市","惠州市","江门市","珠海市","汕头市","佛山市","湛江市","河源市","肇庆市","清远市","潮州市","韶关市","揭阳市","阳江市","梅州市","云浮市","茂名市","汕尾市",
        " 海南","三亚市","海口市","琼海市","文昌市","东方市","昌江县","陵水县","乐东县","保亭县","五指山市","澄迈县","万宁市","儋州市","临高县","白沙县","定安县","琼中县","屯昌县",
        " 四川", "成都市","绵阳市","广元市","达州市","南充市","德阳市","广安市","阿坝州","巴中市","遂宁市","内江市","凉山州","攀枝花市","乐山市","自贡市","泸州市","雅安市","宜宾市","资阳市","眉山市","甘孜州",
        " 贵州","贵阳市","黔东南州","黔南州","遵义市","黔西南州","毕节地区","铜仁地区","安顺市","六盘水市",
        " 云南", "昆明市","红河州","大理州","文山州","德宏州","曲靖市","昭通市","楚雄州","保山市","玉溪市","丽江地区","临沧地区","思茅地区","西双版纳州","怒江州","迪庆州",
        " 陕西","西安市","咸阳市","宝鸡市","汉中市","渭南市","安康市","榆林市","商洛市","延安市","铜川市",
        " 甘肃", "兰州市","天水市","庆阳市","武威市","酒泉市","张掖市","陇南地区","白银市","定西地区","平凉市","嘉峪关市","临夏回族自治州","金昌市","甘南州",
        " 青海", "西宁市","海西州","海东地区","海北州","果洛州","玉树州","黄南藏族自治州",
        " 台湾", "台北市","高雄市","台中市","新竹市","基隆市","台南市","嘉义市",
        " 内蒙古","赤峰市","包头市","通辽市","呼和浩特市","鄂尔多斯市","乌海市","呼伦贝尔市","兴安盟","巴彦淖尔盟","乌兰察布盟","锡林郭勒盟","阿拉善盟",
        " 广西", "贵港市","玉林市","北海市","南宁市","柳州市","桂林市","梧州市","钦州市","来宾市","河池市","百色市","贺州市","崇左市","防城港市",
        " 西藏", "拉萨市","山南地区","林芝地区","日喀则地区","阿里地区","昌都地区","那曲地区",
        " 宁夏", "银川市","吴忠市","中卫市","石嘴山市","固原市",
        " 新疆", "乌鲁木齐市","伊犁州","昌吉州","石河子市","哈密地区","阿克苏地区","巴音郭楞州","喀什地区","塔城地区","克拉玛依市","和田地区","阿勒泰州","吐鲁番地区","阿拉尔市","博尔塔拉州","五家渠市","克孜勒苏州","图木舒克市",
        " 国外", "安哥拉","阿富汗","阿尔巴尼亚","阿尔及利亚","安道尔共和国","安圭拉岛","安提瓜和巴布达","阿根廷","亚美尼亚","阿森松","澳大利亚","奥地利","阿塞拜疆","巴哈马","巴林","孟加拉国","巴巴多斯",
        "白俄罗斯","比利时","伯利兹","贝宁","百慕大群岛","玻利维亚","博茨瓦纳","巴西","文莱","保加利亚","布基纳法索","缅甸","布隆迪","喀麦隆","加拿大","开曼群岛","中非共和国","乍得","智利",
        "哥伦比亚","刚果","库克群岛","哥斯达黎加","古巴","塞浦路斯","捷克","丹麦","吉布提","多米尼加共和国","厄瓜多尔","埃及","萨尔瓦多","爱沙尼亚","埃塞俄比亚","斐济","芬兰","法国","法属圭亚那","加蓬","冈比亚",
        "格鲁吉亚","德国","加纳","直布罗陀","希腊","格林纳达","关岛","危地马拉","几内亚","圭亚那","海地","洪都拉斯","香港","匈牙利","冰岛","印度","印度尼西亚","伊朗","伊拉克","爱尔兰","以色列","意大利","科特迪瓦",
        "牙买加","日本","约旦","柬埔寨","哈萨克斯坦","肯尼亚","韩国","科威特","吉尔吉斯坦","老挝","拉脱维亚","黎巴嫩","莱索托","利比里亚","利比亚","列支敦士登","立陶宛","卢森堡","澳门","马达加斯加","马拉维","马来西亚",
        "马尔代夫","马里","马耳他","马里亚那群岛","马提尼克","毛里求斯","墨西哥",",摩尔多瓦","摩纳哥","蒙古","蒙特塞拉特岛","摩洛哥","莫桑比克","纳米比亚","瑙鲁","尼泊尔","荷属安的列斯","荷兰","新西兰","尼加拉瓜","尼日尔",
        "尼日利亚","朝鲜","挪威","阿曼","巴基斯坦","巴拿马","巴布亚新几内亚","巴拉圭","秘鲁","菲律宾","波兰","法属玻利尼西亚","葡萄牙","波多黎各","卡塔尔","留尼旺","罗马尼亚","俄罗斯","圣卢西亚","圣文森特岛","东萨摩亚",
        "西萨摩亚","圣马力诺","圣多美和普林西比","沙特阿拉伯","塞内加尔","塞舌尔","塞拉利昂","新加坡","斯洛伐克","斯洛文尼亚","所罗门群岛","索马里","南非","西班牙","斯里兰卡","圣卢西亚","圣文森特","苏丹","苏里南",
        "斯威士兰","瑞典","瑞士","叙利亚","台湾省","塔吉克斯坦","坦桑尼亚","泰国","多哥","汤加","特立尼达和多巴哥","突尼斯","土耳其","土库曼斯坦","乌干达","乌克兰","阿拉伯联合酋长国","英国","美国","乌拉圭","乌兹别克斯坦",
        "委内瑞拉","越南","也门","南斯拉夫","津巴布韦","扎伊尔","赞比亚"};
}
