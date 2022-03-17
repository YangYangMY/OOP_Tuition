public class Tuition {
    public static void main(String[] args){
        People[] stuArray = new Student[100];
        dummyData(stuArray);
        
        System.out.println(stuArray[0].toString());
        System.out.println(stuArray[1].toString());
    }
    
    public static void dummyData(People[] stuArray){
        stuArray[0] = new Student("Zhi Lin Wei ", 27, 'F', "+6014-5371 2077", "linwei88@gmail.com", "Student", 0.0);
        stuArray[1] = new Student("Adam Hanif Bin Hisham", 30, 'M', "+6012-273 7001", "adamhanif232@hotmail.com", "", 40.0);
        stuArray[2] = new Student("Wan Syahmi Bin Shahir", 22, 'M', "+6019-726 0268", "wansyahmi98@gmail.com", "Student", 60.0);
        stuArray[3] = new Student("Ama A/P Selvam", 16, 'F', "+6016-335 7323", "amaletcuman112@gmail.com ", "", 0.0);
        stuArray[4] = new Student("Megan Liu", 19, 'F', "+6017-699 8605", "meganliu225@outlook.com", "Student", 60.0);
        stuArray[5] = new Student("Qiu Jing Wen", 20, 'F', "+6019-608 8240", "jingwenqiu85@outlook.com", "Learner", 0.0);
        stuArray[6] = new Student("Frankie Coleen", 21, 'M', "+6018-7785 5570", "frankiecol213@outlook.com", "Student", 60.0);
        stuArray[7] = new Student("Sarah Yesmin Binti Osman", 17, 'F', "+6019-877 5873", "sarahyesmin66@gmail.com", "Learner", 60.0);
        stuArray[8] = new Student("Danush A/L Rajakumar", 22, 'M', "+6012-803 2142", "danusaja1006@gmail.com", "", 80.0);
        stuArray[9] = new Student("Lim Qiu Yang", 16, 'M', "+6010-634 4880", "qiuyang0206@hotmail.com", "Student", 40.0);
        stuArray[10] = new Student("Jimmy Chong", 28, 'M', "+6014-2001 5371", "jimmychong@gmail.com", "Learner", 20.0);
        stuArray[11] = new Student("Adil Mutur Bin Hasif", 17, 'M', "+6012-103 7021", "adilmutur32@hotmail.com", "Learner", 20.0);
        stuArray[12] = new Student("Nurul Aisah Binti Ismail", 25, 'F', "+6019-520 7354", "nurulaisah08@gmail.com ", "", 60.0);
        stuArray[13] = new Student("Monicca A/P Ciwa", 21, 'F', "+6016-888 4738", "moniccaciwa19@gmail.com", "Student", 40.0);
        stuArray[14] = new Student("Joanne Kwong", 27, 'F', "+6017-472 6943", "joannekwong83@outlook.com ", "", 60.0);
        stuArray[15] = new Student("Lui Shuhui", 30, 'F', "+6019-7832 6518", "luishuhui826@outlook.com", "Student", 20.0);
        stuArray[16] = new Student("Scarlet Johnson", 24, 'F', "+6018-5468 7954", "scarletjohnson23@outlook.com", "Learner", 60.0);
        stuArray[17] = new Student("Isma Fatimah Binti Zamzui", 28, 'F', "+6019-552 2975", "ismafatimah67@gmail.com", "Student", 60.0);
        stuArray[18] = new Student("Loganish A/L Ramu", 16, 'M', "+6012-8269 3572", "loganisamu007@gmail.com ", "Student", 60.0);
        stuArray[19] = new Student("Law Li Xian", 30, 'M', "+6010-330 0231", "lawlixian161@hotmail.com", "", 0.0);
        stuArray[20] = new Student("Ong Paul Cheng", 30, 'M', "+6014-8947 5243", "paulcheng220@gmail.com", "Student", 0.0);
        stuArray[21] = new Student("Danial Fasih Bin Nazif", 27, 'M', "+6012-183 7471", "danialfasih774@hotmail.com", "", 40.0);
        stuArray[22] = new Student("Suratin bin Zainal", 16, 'M', "+6019-153 0237", "suratinzainal89@gmail.com", "Learner", 0.0);
        stuArray[23] = new Student("Parvina Jay A/P Jiko", 28, 'F', "+6016-7934 6134", "parvinajay77@gmail.com", "Student", 40.0);
        stuArray[24] = new Student("Frankie Kee", 16, 'M', "+6017-696 8958", "frankiekee0130@outlook.com", "Learner", 20.0);
        stuArray[25] = new Student("Lim Zhi Yang", 30, 'M', "+6019-771 8812", "limzhiyang1010@outlook.com", "Student", 80.0);
        stuArray[26] = new Student("Cis Evann", 30, 'M', "+6018-1315 7870", "cisevann176@outlook.com", "Learner", 40.0);
        stuArray[27] = new Student("Rauida Binti Sanawi", 25, 'F', "+6019-7870 1937", "rauidasanawi33@gmail.com", "Student", 40.0);
        stuArray[28] = new Student("Rutanram A/L Ramaraw", 17, 'M', "+6012-8264 5862", "rutanram554@gmail.com ", "", 80.0);
        stuArray[29] = new Student("Foo Yoon Ping ", 23, 'M', "+6010-103 5843", "fooyoonping0147@hotmail.com", "Student", 40.0);
        stuArray[30] = new Student("Lee Yi Nan ", 21, 'M', "+6014-131 4583", "leeyinan2525@gmail.com", "", 40.0);
        stuArray[31] = new Student("Haikal Adam bin Kharul", 22, 'M', "+6012-8343 0260", "haikaladam2421@hotmail.com", "Student", 0.0);
        stuArray[32] = new Student("Alif bin Ramli", 25, 'M', "+6019-843 5386", "aliframli93@gmail.com", "Learner", 0.0);
        stuArray[33] = new Student("Pojasha A/P Nisah", 16, 'F', "+6016-6656 6572", "pojasha44@gmail.com", "Student", 80.0);
        stuArray[34] = new Student("Jason Ng", 17, 'M', "+6017-778 9170", "jasonng917@outlook.com", "", 60.0);
        stuArray[35] = new Student("Mooi Wei Xiang", 27, 'M', "+6019-4562 5438", "mooiweixiang0104@outlook.com", "Student", 40.0);
        stuArray[36] = new Student("Tom Holland", 26, 'M', "+6018-9968 2456", "tomholland777@outlook.com", "", 60.0);
        stuArray[37] = new Student("Sura Binti Qistina", 25, 'F', "+6019-183 1476", "suraqistina724@gmail.com", "Student", 80.0);
        stuArray[38] = new Student("Hanmah A/L Imbi", 17, 'M', "+6012-7706 3632", "hanman14335@gmail.com", "Learner", 0.0);
        stuArray[39] = new Student("Neo Zheng Ping", 29, 'M', "+6010-771 1290", "neozhengping971@hotmail.com", "Student", 0.0);
        stuArray[40] = new Student("Oh Kai Ann", 21, 'F', "+6011-990 7400", "kaiann99@hotmail.com", "Learner", 40.0);
        stuArray[41] = new Student("Yeoh Xin Ooi", 30, 'F', "+6014-868 3376", "xinooi01@gmail.com", "", 80.0);
        stuArray[42] = new Student("Hoo Gam Ee", 25, 'F', "+6013-172 3326", "gamee682@outlook.com", "Student", 60.0);
        stuArray[43] = new Student("Fong Cheam Tai", 29, 'M', "+6019-509 4439", "cheamtai88@gmail.com", "Learner", 0.0);
        stuArray[44] = new Student("Pang Cheung Ooi", 27, 'M', "+6012-213 2544", "cheungooi789@gmail.com", "", 80.0);
        stuArray[45] = new Student("Meng Shao Wang", 24, 'M', "+6019-978 5699", "shaowang111@hotmail.com", "Student", 80.0);
        stuArray[46] = new Student("Loh Koh June", 28, 'F', "+6019-223 1893", "kohjune77@yahoo.com", "Learner", 0.0);
        stuArray[47] = new Student("Yang Wong Keen", 24, 'F', "+6016-771 3849", "wongkeen100@gmail.com", "Student", 40.0);
        stuArray[48] = new Student("Yang Pui Wong", 27, 'F', "+6011-715 0244", "puiwong36@gmail.com", "Learner", 40.0);
        stuArray[49] = new Student("Ooi Shao Chong", 19, 'M', "+6019-294 6849", "shaochong43@gmail.com", "Student", 40.0);
    };
}
