insert into city(id,_name) values (null,"تهران");
insert into city(id,_name) values (null,"مشهد");
insert into city(id,_name) values (null,"شاهرود");
insert into city(id,_name) values (null,"سبزوار");
insert into city(id,_name) values (null,"سمنان");
insert into city(id,_name) values (null,"کرج");
insert into city(id,_name) values (null,"گرمسار");
insert into city(id,_name) values (null,"خرم آباد");
insert into city(id,_name) values (null,"نور");
insert into city(id,_name) values (null,"تبریز");
insert into city(id,_name) values (null,"بندر عباس");
insert into city(id,_name) values (null,"اهواز");
insert into city(id,_name) values (null,"محمودآباد");
insert into city(id,_name) values (null,"محمودآباد");
insert into city(id,_name) values (null,"یزد");
insert into city(id,_name) values (null,"اصفهان");
insert into city(id,_name) values (null,"شهرکرد");
insert into city(id,_name) values (null,"ارومیه");
insert into city(id,_name) values (null,"بجنورد");
insert into city(id,_name) values (null,"کرمان");
insert into city(id,_name) values (null,"کرمانشاه");
insert into city(id,_name) values (null,"شیراز");

insert into zone(id,_name,city_id) values (null,"اقدسیه",1);
insert into zone(id,_name,city_id) values (null,"چیتگر",1);
insert into zone(id,_name,city_id) values (null,"حومه",1);
insert into zone(id,_name,city_id) values (null,"سعادت آباد",1);
insert into zone(id,_name,city_id) values (null,"حومه",14);
insert into zone(id,_name,city_id) values (null,"چهارراه ولیعصر",1);
insert into zone(id,_name,city_id) values (null,"آرژانتین",1);
insert into zone(id,_name,city_id) values (null,"سید خندان",1);
insert into zone(id,_name,city_id) values (null,"شوش",1);
insert into zone(id,_name,city_id) values (null,"چنارسوخته",3);
insert into zone(id,_name,city_id) values (null,"فرهنگیان",3);
insert into zone(id,_name,city_id) values (null,"تخت جمشید",3);
insert into zone(id,_name,city_id) values (null,"تخت جمشید",21);
insert into zone(id,_name,city_id) values (null,"طالقانی",6);
insert into zone(id,_name,city_id) values (null,"اندیشه",1);
insert into zone(id,_name,city_id) values (null,"حومه",3);
insert into zone(id,_name,city_id) values (null,"حومه",14);
insert into zone(id,_name,city_id) values (null,"حومه",19);
insert into zone(id,_name,city_id) values (null,"تهرانپارس",1);
insert into zone(id,_name,city_id) values (null,"پیروزی",2);
insert into zone(id,_name,city_id) values (null,"اکباتان",1);
insert into zone(id,_name,city_id) values (null,"بلوار کشاورز",1);



insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","Porche 911 GT",false,false,"09101233212",null,"Porche 911 GT",false,1,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"911 GT",0.0,2018,1);
insert into car(kilometerage,id) values (null,1);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","بیا بخر ماشنو",false,false,"0910654212",null,"پراید سفید",false,1,2);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Pride",100000000.0,98,2);
insert into car(kilometerage,id) values (null,2);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me",false,true,"091012333412","/x.png","فروش BMW",false,1,3);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"BMW M3",1000000000.0,96,3);
insert into car(kilometerage,id) values (null,3);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me if you can",false,true,"093012333412","/xs.png","فروش Benz",true,1,4);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Benz C120",1300000000.0,93,4);
insert into car(kilometerage,id) values (null,4);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me",false,true,"091012333412","/x.png","فروش BMW new",false,3,5);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"BMW X1",1500000000.0,88,5);
insert into car(kilometerage,id) values (null,5);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me",true,false,"091012333412",null,"فروش  یا معاوضه شورلت",false,2,20);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"BMW M3",1000000000.0,90,6);
insert into car(kilometerage,id) values (null,6);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (7,"ON_SALE","عالی",true,false,"09129993412",null,"ژیان",false,5,4);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Citroen",16000000.0,91,7);
insert into car(kilometerage,id) values (null,7);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me",false,true,"09109993412","/xczx.png","فروش  یا معاوضه شورلت",false,20,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Z1",100000000.0,91,8);
insert into car(kilometerage,id) values (null,8);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Call me now",true,true,"09109993412","/ax.png","Hummer شورلت",true,8,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Hummer",1900000000.0,93,9);
insert into car(kilometerage,id) values (null,9);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","wat",true,false,"09900293412","/xczx.png","206 sd",true,10,10);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"206",60000000.0,85,10);
insert into car(kilometerage,id) values (null,10);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","buy now",false,true,"09194123122","/xس.png","پژو 405",false,15,null);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"405",30000000.0,84,11);
insert into car(kilometerage,id) values (null,11);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","بخر",false,true,"09109990012","/xشzx.png","207 بخر",true,12,3);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"207",180000000.0,87,12);
insert into car(kilometerage,id) values (null,12);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","Cadsame",true,false,"09109493412",null,"206 تصادفی",false,19,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"206",30000000.0,90,13);
insert into car(kilometerage,id) values (null,13);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (14,"ON_SALE","چی",false,true,"091799223412","/xcszx.png","پیکان",true,21,14);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Peykan",20000000.0,83,14);
insert into car(kilometerage,id) values (null,14);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (15,"ON_SALE","چasdی",false,false,"091899223412",null,"تویوتا",true,21,null);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Toyota",600000000.0,91,15);
insert into car(kilometerage,id) values (null,15);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","چasdیasd",true,true,"091799223412","/axz.png","مزدا",true,18,null);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Mazda 3",300000000.0,88,16);
insert into car(kilometerage,id) values (null,16);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (17,"ON_SALE","asdچی",true,true,"09192131222","/xcszx.png","Lotus",false,19,19);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Elize",2000000000.0,83,17);
insert into car(kilometerage,id) values (null,17);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","چی",false,false,"091799223412",null,"mystery",true,3,17);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"X",0.0,83,18);
insert into car(kilometerage,id) values (null,18);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","sad",false,true,"093799223412",null,"asdx",true,5,null);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Tiba",60000000.0,97,19);
insert into car(kilometerage,id) values (30000,19);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (20,"ON_SALE","12asd3d",false,false,"093799215412",null,"sd3x",false,1,21);
insert into vehicle(for_rent,model,price,production_year,id) values (false,"Tiba",4000000,91,20);
insert into car(kilometerage,id) values (80000,20);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (21,"ON_SALE","123d",false,false,"093799223412",null,"a23x",false,1,21);
insert into vehicle(for_rent,model,price,production_year,id) values (true,"Tiba",-2.0,91,21);
insert into car(kilometerage,id) values (80000,21);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","sad",false,false,"093713223412",null,"any",false,1,22);
insert into vehicle(for_rent,model,price,production_year,id) values (false,null,20000000,91,22);
insert into car(kilometerage,id) values (50000,22);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","kamioon",true,true,"09371303412","/kma.jpg","truck mikham",false,1,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,null,20000000,91,23);
insert into truck(kilometerage,id) values (150000,23);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","treily",true,true,"09871303412","/treil.jpg","18 charkh",false,1,1);
insert into vehicle(for_rent,model,price,production_year,id) values (true,null,0.0,58,24);
insert into truck(kilometerage,id) values (1500000,24);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","call",false,true,"09371303412",null,"compressi",true,1,2);
insert into vehicle(for_rent,model,price,production_year,id) values (false,"compressi",400000000,86,25);
insert into truck(kilometerage,id) values (300000,25);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","نوساز",false,false,"09971303412",null,"آپارتمان شیک",false,1,1);
insert into real_estate(area,rooms,type,id) values (110.5,2,"REAL_STATE",26);
insert into residential_sell(price,id) values(1000000,26);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","نوساز",true,false,"09971303412",null,"Good آپارتمان شیک",false,1,7);
insert into real_estate(area,rooms,type,id) values (120.5,3,"REAL_STATE",27);
insert into residential_sell(price,id) values(900000,27);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","نوساز",true,false,"09981303412",null,"Good مان آپارتمان",false,1,3);
insert into real_estate(area,rooms,type,id) values (101.0,2,"PERSONAL",28);
insert into residential_sell(price,id) values(300000000,28);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","",true,false,"09981323412",null,"کلنگی",false,1,3);
insert into real_estate(area,rooms,type,id) values (325,0,"REAL_ESTATE",29);
insert into residential_sell(price,id) values(500000000,29);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","نوساز",true,true,"09981323412","/sada.jpg","مطب",true,1,3);
insert into real_estate(area,rooms,type,id) values (80.3,3,"PERSONAL",30);
insert into commercial_sell(legal_instrument,price,id) values(false,300000000,30);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","koochik",true,true,"09981923412","/saسda.jpg","مغازه",true,1,3);
insert into real_estate(area,rooms,type,id) values (null,3,"PERSONAL",31);
insert into commercial_sell(legal_instrument,price,id) values(false,300000000,31);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09980029412","/sd.jpg","ویلا",true,1,7);
insert into real_estate(area,rooms,type,id) values (530,2,"PERSONAL",32);
insert into residential_rent(deposit,rent,id) values(10000000,3000000,32);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09980029412","/sd.jpg","خانه",true,1,6);
insert into real_estate(area,rooms,type,id) values (100,2,"REAL_ESTATE",33);
insert into residential_rent(deposit,rent,id) values(8000000,900000,33);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09080029412","/sd.jpg","good خانه",false,1,6);
insert into real_estate(area,rooms,type,id) values (600,2,"PERSONAL",34);
insert into residential_rent(deposit,rent,id) values(80000000,9000000,34);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","khob",false,false,"09080029412",null,"good خانه",false,1,null);
insert into real_estate(area,rooms,type,id) values (550,4,"PERSONAL",35);
insert into residential_rent(deposit,rent,id) values(-2.0,-2.0,35);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","وقفی",true,false,"09981323412",null,"زمین",false,1,3);
insert into real_estate(area,rooms,type,id) values (240,0,"REAL_ESTATE",36);
insert into residential_sell(price,id) values(1200000000,36);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"REQUESTED","koochik",true,true,"09981923412","/saسda.jpg","دفتر کار",true,1,5);
insert into real_estate(area,rooms,type,id) values (80,2,"PERSONAL",37);
insert into commercial_sell(legal_instrument,price,id) values(false,300000000,37);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09981923412","/saسda.jpg","اتاق اذاری",true,1,7);
insert into real_estate(area,rooms,type,id) values (50,1,"PERSONAL",38);
insert into commercial_sell(legal_instrument,price,id) values(false,300000000,38);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09980029412","/sd.jpg","خانه",true,1,4);
insert into real_estate(area,rooms,type,id) values (600,2,"PERSONAL",39);
insert into residential_sell(price,id) values(700000000,39);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09980029412","/sd.jpg","ویلا",true,1,3);
insert into real_estate(area,rooms,type,id) values (450,2,"PERSONAL",40);
insert into residential_sell(price,id) values(500000000,40);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","koochik",true,true,"09080029412","/qwe.jpg","آ‍پارتمان",false,1,2);
insert into real_estate(area,rooms,type,id) values (300,2,"PERSONAL",41);
insert into residential_rent(deposit,rent,id) values(200000,-2,41);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","bozorge",true,true,"09080029412","/rqwe.jpg","آ‍پارتمان",true,1,6);
insert into real_estate(area,rooms,type,id) values (600,2,"PERSONAL",42);
insert into residential_rent(deposit,rent,id) values(100000000,-2,42);

insert into advertisement(id,ad_type,description,exchange,has_image,mobile,picture,title,urgent,city_id,zone_id) values (null,"ON_SALE","",true,true,"09080029412","/sd.jpg","آ‍پارتمان",false,1,12);
insert into real_estate(area,rooms,type,id) values (220,2,"PERSONAL",43);
insert into residential_rent(deposit,rent,id) values(80000000,-2,43);

