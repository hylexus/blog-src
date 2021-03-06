CREATE DATABASE IF NOT EXISTS common
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;
# http://blog.csdn.net/a364572/article/details/50483568
CREATE TABLE station
(
  id   INT AUTO_INCREMENT
    PRIMARY KEY,
  name VARCHAR(20) NULL,
  lng  DOUBLE      NULL
  COMMENT '经度',
  lat  DOUBLE      NULL
  COMMENT '维度'
);

INSERT INTO common.station (name, lng, lat) VALUES ('七宝', 121.34882432933009, 31.155364678184498);
INSERT INTO common.station (name, lng, lat) VALUES ('三林', 121.51232441787553, 31.143310799728642);
INSERT INTO common.station (name, lng, lat) VALUES ('三林东', 121.52323368244738, 31.14652508348235);
INSERT INTO common.station (name, lng, lat) VALUES ('三门路', 121.50799517049789, 31.31309147023961);
INSERT INTO common.station (name, lng, lat) VALUES ('上南路', 121.50641282615508, 31.149112456634267);
INSERT INTO common.station (name, lng, lat) VALUES ('上大路', 121.40917904964138, 31.313523580629315);
INSERT INTO common.station (name, lng, lat) VALUES ('上海体育场', 121.44371311565101, 31.185521626172694);
INSERT INTO common.station (name, lng, lat) VALUES ('上海体育馆', 121.43705494092909, 31.182722479037928);
INSERT INTO common.station (name, lng, lat) VALUES ('上海儿童医学中心', 121.52392638303307, 31.204050478629366);
INSERT INTO common.station (name, lng, lat) VALUES ('上海动物园', 121.36802420861451, 31.190193987444363);
INSERT INTO common.station (name, lng, lat) VALUES ('上海南站', 121.43013581785462, 31.1546882895589);
INSERT INTO common.station (name, lng, lat) VALUES ('上海图书馆', 121.44343879031237, 31.207570983863118);
INSERT INTO common.station (name, lng, lat) VALUES ('上海游泳馆', 121.4413695531946, 31.17939640791577);
INSERT INTO common.station (name, lng, lat) VALUES ('上海火车站', 121.45580523010531, 31.24722802213976);
INSERT INTO common.station (name, lng, lat) VALUES ('上海科技馆', 121.54296075651668, 31.21976006243433);
INSERT INTO common.station (name, lng, lat) VALUES ('上海西站', 121.3995217963426, 31.26402206282826);
INSERT INTO common.station (name, lng, lat) VALUES ('上海马戏城', 121.45212090786323, 31.279316280742993);
INSERT INTO common.station (name, lng, lat) VALUES ('世纪公园', 121.55050963740068, 31.210579130453606);
INSERT INTO common.station (name, lng, lat) VALUES ('世纪大道', 121.52710487067272, 31.22889232359548);
INSERT INTO common.station (name, lng, lat) VALUES ('东安路', 121.45474096208387, 31.19063724208337);
INSERT INTO common.station (name, lng, lat) VALUES ('东川路', 121.4198816325649, 31.01817606663319);
INSERT INTO common.station (name, lng, lat) VALUES ('东方体育中心', 121.48035206401129, 31.1534473113927);
INSERT INTO common.station (name, lng, lat) VALUES ('东昌路', 121.51567018559844, 31.233220760629376);
INSERT INTO common.station (name, lng, lat) VALUES ('东明路', 121.51100690462818, 31.17273725768231);
INSERT INTO common.station (name, lng, lat) VALUES ('东陆路', 121.57886972578382, 31.28249657164053);
INSERT INTO common.station (name, lng, lat) VALUES ('中兴路', 121.46863197770557, 31.254467518561388);
INSERT INTO common.station (name, lng, lat) VALUES ('中华艺术宫', 121.4937458716661, 31.184972850007277);
INSERT INTO common.station (name, lng, lat) VALUES ('中山公园', 121.41621048510926, 31.218222120188734);
INSERT INTO common.station (name, lng, lat) VALUES ('中山北路', 121.45937829291408, 31.259516296150416);
INSERT INTO common.station (name, lng, lat) VALUES ('中春路', 121.33877429456082, 31.149860448696764);
INSERT INTO common.station (name, lng, lat) VALUES ('丰庄', 121.35531214937316, 31.242424875125327);
INSERT INTO common.station (name, lng, lat) VALUES ('临平路', 121.50088719498645, 31.260949165642312);
INSERT INTO common.station (name, lng, lat) VALUES ('临沂新村', 121.51755359069277, 31.1937122909819);
INSERT INTO common.station (name, lng, lat) VALUES ('临港大道', 121.91066263081674, 30.923606918099505);
INSERT INTO common.station (name, lng, lat) VALUES ('九亭', 121.31869886917752, 31.137308476349332);
INSERT INTO common.station (name, lng, lat) VALUES ('书院', 121.8506634012499, 30.95926123507124);
INSERT INTO common.station (name, lng, lat) VALUES ('云台路', 121.50035968702596, 31.182220942193283);
INSERT INTO common.station (name, lng, lat) VALUES ('云山路', 121.57200400870633, 31.249949676884818);
INSERT INTO common.station (name, lng, lat) VALUES ('云锦路', 121.45844263985741, 31.167577554973168);
INSERT INTO common.station (name, lng, lat) VALUES ('五角场', 121.51449108658478, 31.29771001866499);
INSERT INTO common.station (name, lng, lat) VALUES ('交通大学', 121.43529231627353, 31.202259878368565);
INSERT INTO common.station (name, lng, lat) VALUES ('人民广场', 121.47607433975561, 31.232372540185658);
INSERT INTO common.station (name, lng, lat) VALUES ('伊犁路', 121.4026608551536, 31.19923633686024);
INSERT INTO common.station (name, lng, lat) VALUES ('兆丰路', 121.15004189291957, 31.28904403535332);
INSERT INTO common.station (name, lng, lat) VALUES ('光明路', 121.11717513184017, 31.29627765857158);
INSERT INTO common.station (name, lng, lat) VALUES ('共富新村', 121.43421300288435, 31.35512507804499);
INSERT INTO common.station (name, lng, lat) VALUES ('共康路', 121.44667448466939, 31.319881104686967);
INSERT INTO common.station (name, lng, lat) VALUES ('凌兆新村', 121.48928060368938, 31.141082275382466);
INSERT INTO common.station (name, lng, lat) VALUES ('凌空路', 121.72321311908215, 31.192663076212906);
INSERT INTO common.station (name, lng, lat) VALUES ('刘行', 121.36433766045478, 31.355867228758683);
INSERT INTO common.station (name, lng, lat) VALUES ('创新中路', 121.67419095114124, 31.213467344574855);
INSERT INTO common.station (name, lng, lat) VALUES ('剑川路', 121.41658960032001, 31.026447527325157);
INSERT INTO common.station (name, lng, lat) VALUES ('北新泾', 121.37274280436714, 31.216937632130573);
INSERT INTO common.station (name, lng, lat) VALUES ('北桥', 121.41004454530024, 31.04505751570457);
INSERT INTO common.station (name, lng, lat) VALUES ('北洋泾路', 121.55208261748719, 31.239008075386373);
INSERT INTO common.station (name, lng, lat) VALUES ('华夏东路', 121.68100325143205, 31.196740988071102);
INSERT INTO common.station (name, lng, lat) VALUES ('华夏中路', 121.5831551419251, 31.175779230721187);
INSERT INTO common.station (name, lng, lat) VALUES ('华夏西路', 121.51470734832817, 31.149885361059827);
INSERT INTO common.station (name, lng, lat) VALUES ('华宁路', 121.39532966670728, 31.007449157110127);
INSERT INTO common.station (name, lng, lat) VALUES ('南京东路', 121.48503207513708, 31.237456155443187);
INSERT INTO common.station (name, lng, lat) VALUES ('南京西路', 121.46059916566237, 31.22992807554203);
INSERT INTO common.station (name, lng, lat) VALUES ('南翔', 121.30541643005107, 31.28125036360488);
INSERT INTO common.station (name, lng, lat) VALUES ('南陈路', 121.39724931199466, 31.321325046577098);
INSERT INTO common.station (name, lng, lat) VALUES ('博兴路', 121.58697345001835, 31.263930845790362);
INSERT INTO common.station (name, lng, lat) VALUES ('友谊西路', 121.42772773690315, 31.38183499925312);
INSERT INTO common.station (name, lng, lat) VALUES ('合川路', 121.3849957673268, 31.167103637855593);
INSERT INTO common.station (name, lng, lat) VALUES ('同济大学', 121.50652000853252, 31.282406501140848);
INSERT INTO common.station (name, lng, lat) VALUES ('后滩', 121.47200452173412, 31.173167803806574);
INSERT INTO common.station (name, lng, lat) VALUES ('周浦东', 121.60692835811028, 31.110087620616742);
INSERT INTO common.station (name, lng, lat) VALUES ('呼兰路', 121.43769466570595, 31.34002562754343);
INSERT INTO common.station (name, lng, lat) VALUES ('唐镇', 121.65602135182546, 31.214068921455702);
INSERT INTO common.station (name, lng, lat) VALUES ('商城路', 121.51643859052282, 31.230447413146383);
INSERT INTO common.station (name, lng, lat) VALUES ('嘉善路', 121.46094849280462, 31.202698707343735);
INSERT INTO common.station (name, lng, lat) VALUES ('四川北路', 121.48399973747985, 31.251756889214807);
INSERT INTO common.station (name, lng, lat) VALUES ('四平路', 121.50148034098908, 31.274805275831106);
INSERT INTO common.station (name, lng, lat) VALUES ('国权路', 121.51003336170254, 31.289237911701278);
INSERT INTO common.station (name, lng, lat) VALUES ('国际客运中心', 121.49843028008092, 31.250129787426722);
INSERT INTO common.station (name, lng, lat) VALUES ('场中路', 121.41377978161574, 31.30262002406309);
INSERT INTO common.station (name, lng, lat) VALUES ('塘桥', 121.51835340658484, 31.209620228209804);
INSERT INTO common.station (name, lng, lat) VALUES ('复兴岛', 121.5612282146563, 31.28076054277109);
INSERT INTO common.station (name, lng, lat) VALUES ('外环路', 121.39300316249057, 31.120916001926393);
INSERT INTO common.station (name, lng, lat) VALUES ('大世界', 121.47947475642655, 31.227210896242205);
INSERT INTO common.station (name, lng, lat) VALUES ('大华三路', 121.42321202580956, 31.27517662964724);
INSERT INTO common.station (name, lng, lat) VALUES ('大场镇', 121.41712893694489, 31.292497996556726);
INSERT INTO common.station (name, lng, lat) VALUES ('大木桥路', 121.46371613240606, 31.194164436990064);
INSERT INTO common.station (name, lng, lat) VALUES ('大渡河路', 121.39426294071832, 31.231820420843412);
INSERT INTO common.station (name, lng, lat) VALUES ('大连路', 121.51297026669526, 31.25794020129161);
INSERT INTO common.station (name, lng, lat) VALUES ('天潼路', 121.48234303671028, 31.243816446126043);
INSERT INTO common.station (name, lng, lat) VALUES ('威宁路', 121.38781824626372, 31.21477799218831);
INSERT INTO common.station (name, lng, lat) VALUES ('娄山关路', 121.4038476510534, 31.211282861323728);
INSERT INTO common.station (name, lng, lat) VALUES ('嫩江路', 121.5319922840845, 31.314685793552073);
INSERT INTO common.station (name, lng, lat) VALUES ('宁国路', 121.5326008715005, 31.26859594508707);
INSERT INTO common.station (name, lng, lat) VALUES ('安亭', 121.17854508954224, 31.30523007143382);
INSERT INTO common.station (name, lng, lat) VALUES ('宋园路', 121.41254617628246, 31.196470628949836);
INSERT INTO common.station (name, lng, lat) VALUES ('宜山路', 121.42757600789544, 31.186798369261055);
INSERT INTO common.station (name, lng, lat) VALUES ('宝安公路', 121.43096622148386, 31.369581144151322);
INSERT INTO common.station (name, lng, lat) VALUES ('富锦路', 121.4245852591679, 31.39230529539033);
INSERT INTO common.station (name, lng, lat) VALUES ('小南门', 121.49853862067285, 31.216999254228547);
INSERT INTO common.station (name, lng, lat) VALUES ('岚皋路', 121.42189898394254, 31.255590400503888);
INSERT INTO common.station (name, lng, lat) VALUES ('川沙', 121.69815619161315, 31.186740867939374);
INSERT INTO common.station (name, lng, lat) VALUES ('巨峰路', 121.5893540832556, 31.280114095536703);
INSERT INTO common.station (name, lng, lat) VALUES ('市光路', 121.532001650599, 31.32273453883129);
INSERT INTO common.station (name, lng, lat) VALUES ('常熟路', 121.45106751722625, 31.213299717796215);
INSERT INTO common.station (name, lng, lat) VALUES ('广兰路', 121.62052743427853, 31.21074892263801);
INSERT INTO common.station (name, lng, lat) VALUES ('延吉中路', 121.53497456322151, 31.288651033846378);
INSERT INTO common.station (name, lng, lat) VALUES ('延长路', 121.45558458158726, 31.271364895899552);
INSERT INTO common.station (name, lng, lat) VALUES ('张华浜', 121.49864036965609, 31.35820341386437);
INSERT INTO common.station (name, lng, lat) VALUES ('张江高科', 121.58764005565338, 31.201691201805993);
INSERT INTO common.station (name, lng, lat) VALUES ('彭浦新村', 121.44879069789918, 31.30567228212954);
INSERT INTO common.station (name, lng, lat) VALUES ('徐家汇', 121.43597965916896, 31.194439896168415);
INSERT INTO common.station (name, lng, lat) VALUES ('徐泾东', 121.30160385761648, 31.189477925236268);
INSERT INTO common.station (name, lng, lat) VALUES ('御桥', 121.57165712572221, 31.1583345033681);
INSERT INTO common.station (name, lng, lat) VALUES ('德平路', 121.56510172138938, 31.24588404135792);
INSERT INTO common.station (name, lng, lat) VALUES ('惠南', 121.76253893511529, 31.053877850513217);
INSERT INTO common.station (name, lng, lat) VALUES ('惠南东', 121.79389640193278, 31.026425187171338);
INSERT INTO common.station (name, lng, lat) VALUES ('成山路', 121.49607903064296, 31.17133021284122);
INSERT INTO common.station (name, lng, lat) VALUES ('打浦桥', 121.46907181245369, 31.207074217869074);
INSERT INTO common.station (name, lng, lat) VALUES ('提篮桥', 121.50667489411764, 31.25347871070924);
INSERT INTO common.station (name, lng, lat) VALUES ('文井路', 121.38080060648888, 31.003579340975918);
INSERT INTO common.station (name, lng, lat) VALUES ('新场', 121.64903859025512, 31.045390486445612);
INSERT INTO common.station (name, lng, lat) VALUES ('新天地', 121.47435200591578, 31.216102118184423);
INSERT INTO common.station (name, lng, lat) VALUES ('新村路', 121.42282747074519, 31.264711872145607);
INSERT INTO common.station (name, lng, lat) VALUES ('新江湾城', 121.50656404573982, 31.32881470460542);
INSERT INTO common.station (name, lng, lat) VALUES ('新闸路', 121.46820189660026, 31.238635751917222);
INSERT INTO common.station (name, lng, lat) VALUES ('昌平路', 121.44291673466627, 31.23333395007012);
INSERT INTO common.station (name, lng, lat) VALUES ('星中路', 121.3686648516916, 31.158560653221556);
INSERT INTO common.station (name, lng, lat) VALUES ('春申路', 121.38577666210973, 31.09826044134633);
INSERT INTO common.station (name, lng, lat) VALUES ('曲阜路', 121.471531743715, 31.242279462875583);
INSERT INTO common.station (name, lng, lat) VALUES ('曲阳路', 121.49027711378072, 31.276551831215528);
INSERT INTO common.station (name, lng, lat) VALUES ('曹杨路', 121.41686527885985, 31.238467038574072);
INSERT INTO common.station (name, lng, lat) VALUES ('杨思', 121.49350019568735, 31.160985623998865);
INSERT INTO common.station (name, lng, lat) VALUES ('杨树浦路', 121.51674913755387, 31.252375796306346);
INSERT INTO common.station (name, lng, lat) VALUES ('杨高中路', 121.54786323441346, 31.227178753342496);
INSERT INTO common.station (name, lng, lat) VALUES ('杨高北路', 121.60297135570602, 31.280101268831253);
INSERT INTO common.station (name, lng, lat) VALUES ('杨高南路', 121.52385366988591, 31.18766080816169);
INSERT INTO common.station (name, lng, lat) VALUES ('松江体育中心', 121.2307007613191, 31.015867143915393);
INSERT INTO common.station (name, lng, lat) VALUES ('松江南站', 121.23102899443168, 30.984299385251294);
INSERT INTO common.station (name, lng, lat) VALUES ('松江新城', 121.23071761730705, 31.030092486653793);
INSERT INTO common.station (name, lng, lat) VALUES ('枫桥路', 121.41036766565539, 31.242515117507665);
INSERT INTO common.station (name, lng, lat) VALUES ('桂林路', 121.41635873799606, 31.174539342743472);
INSERT INTO common.station (name, lng, lat) VALUES ('桃浦新村', 121.35049466986072, 31.28144016128968);
INSERT INTO common.station (name, lng, lat) VALUES ('武威路', 121.36249727316545, 31.279919663329377);
INSERT INTO common.station (name, lng, lat) VALUES ('武宁路', 121.43069735630984, 31.23450295332521);
INSERT INTO common.station (name, lng, lat) VALUES ('殷高东路', 121.50658892229826, 31.321819989498913);
INSERT INTO common.station (name, lng, lat) VALUES ('民生路', 121.54457057851566, 31.23615829609551);
INSERT INTO common.station (name, lng, lat) VALUES ('水产路', 121.48766228418789, 31.382361926548132);
INSERT INTO common.station (name, lng, lat) VALUES ('水城路', 121.3922596904041, 31.199369794009563);
INSERT INTO common.station (name, lng, lat) VALUES ('汉中路', 121.45829824101727, 31.241874932960854);
INSERT INTO common.station (name, lng, lat) VALUES ('江浦公园', 121.52370510780659, 31.264468286537646);
INSERT INTO common.station (name, lng, lat) VALUES ('江浦路', 121.51858593739529, 31.274925780533724);
INSERT INTO common.station (name, lng, lat) VALUES ('江湾体育场', 121.5140188265192, 31.303096805225746);
INSERT INTO common.station (name, lng, lat) VALUES ('江苏路', 121.43100342732576, 31.21935537545074);
INSERT INTO common.station (name, lng, lat) VALUES ('汶水路', 121.45023685080403, 31.292659482920037);
INSERT INTO common.station (name, lng, lat) VALUES ('浦三路', 121.53935849476223, 31.151033540519165);
INSERT INTO common.station (name, lng, lat) VALUES ('浦东大道', 121.51938129249397, 31.239885948887974);
INSERT INTO common.station (name, lng, lat) VALUES ('浦电路_6', 121.52880355301397, 31.220597547726918);
INSERT INTO common.station (name, lng, lat) VALUES ('浦电路_4', 121.53219997422454, 31.222255694092468);
INSERT INTO common.station (name, lng, lat) VALUES ('海伦路', 121.48869581270898, 31.259210624621865);
INSERT INTO common.station (name, lng, lat) VALUES ('淞发路', 121.5000504714655, 31.34451291310542);
INSERT INTO common.station (name, lng, lat) VALUES ('淞虹路', 121.36040929664462, 31.218093093844796);
INSERT INTO common.station (name, lng, lat) VALUES ('源深体育中心', 121.53423071971604, 31.232916055601027);
INSERT INTO common.station (name, lng, lat) VALUES ('滴水湖', 121.92992631486327, 30.90686682003928);
INSERT INTO common.station (name, lng, lat) VALUES ('漕宝路', 121.4349516747291, 31.168391092770612);
INSERT INTO common.station (name, lng, lat) VALUES ('漕河泾开发区', 121.39742118119938, 31.170785552814646);
INSERT INTO common.station (name, lng, lat) VALUES ('潘广路', 121.356190367134, 31.363900292554373);
INSERT INTO common.station (name, lng, lat) VALUES ('灵岩南路', 121.49526754777136, 31.148724073806697);
INSERT INTO common.station (name, lng, lat) VALUES ('爱国路', 121.55256237460898, 31.27982941513001);
INSERT INTO common.station (name, lng, lat) VALUES ('申江路', 121.6268259739494, 31.280124714064726);
INSERT INTO common.station (name, lng, lat) VALUES ('真北路', 121.38219843817527, 31.23221353098884);
INSERT INTO common.station (name, lng, lat) VALUES ('真如', 121.40730037364763, 31.25088430786696);
INSERT INTO common.station (name, lng, lat) VALUES ('祁连山南路', 121.36732094791691, 31.237648091883443);
INSERT INTO common.station (name, lng, lat) VALUES ('祁连山路', 121.37718657480467, 31.271564545556238);
INSERT INTO common.station (name, lng, lat) VALUES ('紫藤路', 121.36355197629997, 31.16945626437646);
INSERT INTO common.station (name, lng, lat) VALUES ('罗山路', 121.59318448607397, 31.153272796020218);
INSERT INTO common.station (name, lng, lat) VALUES ('翔殷路', 121.53195120433887, 31.30504699083188);
INSERT INTO common.station (name, lng, lat) VALUES ('耀华路', 121.49467758869665, 31.17854036464122);
INSERT INTO common.station (name, lng, lat) VALUES ('老西门', 121.48288688906389, 31.218780662546777);
INSERT INTO common.station (name, lng, lat) VALUES ('肇嘉浜路', 121.45049103504475, 31.199474408844278);
INSERT INTO common.station (name, lng, lat) VALUES ('航中路', 121.35374788341416, 31.165215168594873);
INSERT INTO common.station (name, lng, lat) VALUES ('航头东', 121.61747616775888, 31.054799695740403);
INSERT INTO common.station (name, lng, lat) VALUES ('芦恒路', 121.49828918977042, 31.11816347787781);
INSERT INTO common.station (name, lng, lat) VALUES ('花木路', 121.56176301852227, 31.213069124921283);
INSERT INTO common.station (name, lng, lat) VALUES ('花桥', 121.10438199212747, 31.298791967028116);
INSERT INTO common.station (name, lng, lat) VALUES ('芳华路', 121.54981757365816, 31.193537331718414);
INSERT INTO common.station (name, lng, lat) VALUES ('莘庄', 121.38545381886642, 31.11109348345842);
INSERT INTO common.station (name, lng, lat) VALUES ('莲花路', 121.40291900255396, 31.130957054094594);
INSERT INTO common.station (name, lng, lat) VALUES ('蓝村路', 121.52820118485592, 31.21188311548426);
INSERT INTO common.station (name, lng, lat) VALUES ('虹口足球场', 121.47923238974592, 31.269919860248034);
INSERT INTO common.station (name, lng, lat) VALUES ('虹桥1号航站楼', 121.3472375914553, 31.191646012815973);
INSERT INTO common.station (name, lng, lat) VALUES ('虹桥火车站', 121.32011899380272, 31.193784547279197);
INSERT INTO common.station (name, lng, lat) VALUES ('虹桥路', 121.42111984295019, 31.197102198908212);
INSERT INTO common.station (name, lng, lat) VALUES ('行知路', 121.4217897975075, 31.28468526993067);
INSERT INTO common.station (name, lng, lat) VALUES ('衡山路', 121.44750862326514, 31.205822678771483);
INSERT INTO common.station (name, lng, lat) VALUES ('西藏北路', 121.46915265194492, 31.263645861037535);
INSERT INTO common.station (name, lng, lat) VALUES ('西藏南路', 121.48962355279374, 31.201661975132666);
INSERT INTO common.station (name, lng, lat) VALUES ('豫园', 121.48752572848137, 31.227735008642448);
INSERT INTO common.station (name, lng, lat) VALUES ('通河新村', 121.44164435503134, 31.330980358839064);
INSERT INTO common.station (name, lng, lat) VALUES ('邮电新村', 121.49430013985378, 31.268427296119075);
INSERT INTO common.station (name, lng, lat) VALUES ('醉白池', 121.22894313665368, 31.00070304562812);
INSERT INTO common.station (name, lng, lat) VALUES ('金京路', 121.6149962993077, 31.279669591945282);
INSERT INTO common.station (name, lng, lat) VALUES ('金平路', 121.41024786227776, 31.011247317511167);
INSERT INTO common.station (name, lng, lat) VALUES ('金桥路', 121.58167862969073, 31.256989696086286);
INSERT INTO common.station (name, lng, lat) VALUES ('金沙江西路', 121.33520966495395, 31.24117206131579);
INSERT INTO common.station (name, lng, lat) VALUES ('金沙江路', 121.41187131127933, 31.231313463340822);
INSERT INTO common.station (name, lng, lat) VALUES ('金海路', 121.63865065250674, 31.263112802269728);
INSERT INTO common.station (name, lng, lat) VALUES ('金科路', 121.6020352756639, 31.20418883832002);
INSERT INTO common.station (name, lng, lat) VALUES ('金运路', 121.31997551738976, 31.240943229197082);
INSERT INTO common.station (name, lng, lat) VALUES ('银都路', 121.390298766833, 31.08930149023658);
INSERT INTO common.station (name, lng, lat) VALUES ('锦江乐园', 121.41414636546688, 31.142197480098318);
INSERT INTO common.station (name, lng, lat) VALUES ('锦绣路', 121.53995367278178, 31.18762877798835);
INSERT INTO common.station (name, lng, lat) VALUES ('镇坪路', 121.43116067383117, 31.24672618370278);
INSERT INTO common.station (name, lng, lat) VALUES ('长寿路', 121.43775284956324, 31.240417282361236);
INSERT INTO common.station (name, lng, lat) VALUES ('长清路', 121.48739104601088, 31.17554848661649);
INSERT INTO common.station (name, lng, lat) VALUES ('闵行开发区', 121.36975265608858, 31.000609768912852);
INSERT INTO common.station (name, lng, lat) VALUES ('陆家嘴', 121.50256727654833, 31.23814739265423);
INSERT INTO common.station (name, lng, lat) VALUES ('陆家浜路', 121.48597012964738, 31.211945518488275);
INSERT INTO common.station (name, lng, lat) VALUES ('陕西南路', 121.45859746110055, 31.21492280946765);
INSERT INTO common.station (name, lng, lat) VALUES ('隆德路', 121.42364519502377, 31.230509828824427);
INSERT INTO common.station (name, lng, lat) VALUES ('隆昌路', 121.54502584843327, 31.275498829422254);
INSERT INTO common.station (name, lng, lat) VALUES ('静安寺', 121.44816628042388, 31.224064648787447);
INSERT INTO common.station (name, lng, lat) VALUES ('鞍山新村', 121.50922996919664, 31.272944660509705);
INSERT INTO common.station (name, lng, lat) VALUES ('顾村公园', 121.37226804147348, 31.345815019057852);
INSERT INTO common.station (name, lng, lat) VALUES ('颛桥', 121.40185735345565, 31.066982951796827);
INSERT INTO common.station (name, lng, lat) VALUES ('马当路', 121.47645886452979, 31.20934106647936);
INSERT INTO common.station (name, lng, lat) VALUES ('高科西路', 121.51005922929785, 31.185506555251425);
INSERT INTO common.station (name, lng, lat) VALUES ('高青路', 121.51570721847065, 31.15941280909692);
INSERT INTO common.station (name, lng, lat) VALUES ('鲁班路', 121.47517054900992, 31.199177804563117);
INSERT INTO common.station (name, lng, lat) VALUES ('鹤沙航城', 121.61127257950602, 31.07756339704106);
INSERT INTO common.station (name, lng, lat) VALUES ('黄兴公园', 121.53318129581368, 31.29579533366537);
INSERT INTO common.station (name, lng, lat) VALUES ('黄兴路', 121.5273704901428, 31.278246910967876);
INSERT INTO common.station (name, lng, lat) VALUES ('黄陂南路', 121.47387516496809, 31.22301515841841);
INSERT INTO common.station (name, lng, lat) VALUES ('龙华', 121.45327813737393, 31.17293561191671);
INSERT INTO common.station (name, lng, lat) VALUES ('龙华中路', 121.4574426404483, 31.18478179512045);
INSERT INTO common.station (name, lng, lat) VALUES ('龙柏新村', 121.37077477867552, 31.177401816545633);
INSERT INTO common.station (name, lng, lat) VALUES ('龙溪路', 121.38140210551086, 31.19512808135995);
INSERT INTO common.station (name, lng, lat) VALUES ('龙耀路', 121.45974559966282, 31.159578424681566);
INSERT INTO common.station (name, lng, lat) VALUES ('龙阳路', 121.55779143957028, 31.20195129492995);
INSERT INTO common.station (name, lng, lat) VALUES ('上海大学站', 121.388821, 31.320586);
INSERT INTO common.station (name, lng, lat) VALUES ('上海汽车城', 121.180783, 31.285419);
INSERT INTO common.station (name, lng, lat) VALUES ('上海赛车场', 121.226054, 31.331818);
INSERT INTO common.station (name, lng, lat) VALUES ('上海野生动物园', 121.699255, 31.050177);
INSERT INTO common.station (name, lng, lat) VALUES ('东宝兴路', 121.480241, 31.259775);
INSERT INTO common.station (name, lng, lat) VALUES ('东靖路', 121.588851, 31.290661);
INSERT INTO common.station (name, lng, lat) VALUES ('中潭路', 121.441112, 31.254585);
INSERT INTO common.station (name, lng, lat) VALUES ('五洲大道', 121.589314, 31.302582);
INSERT INTO common.station (name, lng, lat) VALUES ('五莲路', 121.587957, 31.272067);
INSERT INTO common.station (name, lng, lat) VALUES ('佘山', 121.22972, 31.104461);
INSERT INTO common.station (name, lng, lat) VALUES ('南浦大桥', 121.499572, 31.208589);
INSERT INTO common.station (name, lng, lat) VALUES ('友谊路', 121.475948, 31.404007);
INSERT INTO common.station (name, lng, lat) VALUES ('嘉定北', 121.237327, 31.391504);
INSERT INTO common.station (name, lng, lat) VALUES ('嘉定新城', 121.254299, 31.330069);
INSERT INTO common.station (name, lng, lat) VALUES ('嘉定西', 121.227862, 31.377092);
INSERT INTO common.station (name, lng, lat) VALUES ('外高桥保税区北', 121.586912, 31.347832);
INSERT INTO common.station (name, lng, lat) VALUES ('外高桥保税区南', 121.60199, 31.321596);
INSERT INTO common.station (name, lng, lat) VALUES ('大柏树', 121.483227, 31.289546);
INSERT INTO common.station (name, lng, lat) VALUES ('宝山路', 121.476377, 31.251571);
INSERT INTO common.station (name, lng, lat) VALUES ('宝杨路', 121.479583, 31.395309);
INSERT INTO common.station (name, lng, lat) VALUES ('延安西路', 121.417064, 31.209581);
INSERT INTO common.station (name, lng, lat) VALUES ('昌吉东路', 121.200381, 31.293546);
INSERT INTO common.station (name, lng, lat) VALUES ('李子园路', 121.389969, 31.269014);
INSERT INTO common.station (name, lng, lat) VALUES ('松江大学城', 121.212038, 31.049385);
INSERT INTO common.station (name, lng, lat) VALUES ('殷高西路', 121.484969, 31.319862);
INSERT INTO common.station (name, lng, lat) VALUES ('江月路', 121.508628, 31.084015);
INSERT INTO common.station (name, lng, lat) VALUES ('江杨北路', 121.439814, 31.407859);
INSERT INTO common.station (name, lng, lat) VALUES ('江湾镇', 121.485079, 31.305508);
INSERT INTO common.station (name, lng, lat) VALUES ('沈杜公路', 121.512228, 31.061418);
INSERT INTO common.station (name, lng, lat) VALUES ('泗泾', 121.260441, 31.118319);
INSERT INTO common.station (name, lng, lat) VALUES ('洞泾', 121.230475, 31.084481);
INSERT INTO common.station (name, lng, lat) VALUES ('洲海路', 121.589409, 31.31231);
INSERT INTO common.station (name, lng, lat) VALUES ('浦东国际机场', 121.805863, 31.150475);
INSERT INTO common.station (name, lng, lat) VALUES ('浦江镇', 121.506386, 31.096238);
INSERT INTO common.station (name, lng, lat) VALUES ('海天三路', 121.797049, 31.168349);
INSERT INTO common.station (name, lng, lat) VALUES ('淞浜路', 121.492829, 31.371073);
INSERT INTO common.station (name, lng, lat) VALUES ('港城路', 121.574851, 31.353017);
INSERT INTO common.station (name, lng, lat) VALUES ('漕溪路', 121.438366, 31.176727);
INSERT INTO common.station (name, lng, lat) VALUES ('白银路', 121.245428, 31.345181);
INSERT INTO common.station (name, lng, lat) VALUES ('石龙路', 121.443193, 31.157918);
INSERT INTO common.station (name, lng, lat) VALUES ('祁华路', 121.373568, 31.322309);
INSERT INTO common.station (name, lng, lat) VALUES ('罗南新村', 121.357447, 31.388727);
INSERT INTO common.station (name, lng, lat) VALUES ('美兰湖', 121.350131, 31.401718);
INSERT INTO common.station (name, lng, lat) VALUES ('联航路', 121.510581, 31.073425);
INSERT INTO common.station (name, lng, lat) VALUES ('航津路', 121.593981, 31.335434);
INSERT INTO common.station (name, lng, lat) VALUES ('虹桥2号航站楼', 121.326252, 31.194222);
INSERT INTO common.station (name, lng, lat) VALUES ('赤峰路', 121.48249, 31.281247);
INSERT INTO common.station (name, lng, lat) VALUES ('远东大道', 121.755373, 31.199436);
INSERT INTO common.station (name, lng, lat) VALUES ('铁力路', 121.461211, 31.408161);
INSERT INTO common.station (name, lng, lat) VALUES ('长江南路', 121.491551, 31.332043);
INSERT INTO common.station (name, lng, lat) VALUES ('马陆', 121.276831, 31.319459);
INSERT INTO common.station (name, lng, lat) VALUES ('龙漕路', 121.444391, 31.169453);
