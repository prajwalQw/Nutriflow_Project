package com.example.nutriflow.detection;

import java.util.HashMap;

public class FoodInformation {
    public static HashMap<String, FoodDetails>
    addFoods() {
        // Create a HashMap to store food information
        HashMap<String, FoodDetails> foodInfoMap = new HashMap<>();

// Adding food information to the HashMap
        foodInfoMap.put("aloo gobi", new FoodDetails(
                "Aloo Gobi is a popular North Indian vegetarian dish made with potatoes (aloo) and cauliflower (gobi) cooked with various spices such as turmeric, cumin, and coriander. It's a flavorful and comforting dish often served with rice or bread.",
                new NutritionalInformation(200, 5, 30, 8)
        ));

        foodInfoMap.put("aloo matar", new FoodDetails(
                "Aloo Matar is a classic Indian curry dish consisting of potatoes (aloo) and green peas (matar) cooked in a spiced tomato-based gravy. It's a simple yet delicious dish that pairs well with rice or Indian breads like roti or naan.",
                new NutritionalInformation(180, 4, 25, 7)
        ));

        foodInfoMap.put("aloo methi", new FoodDetails(
                "Aloo Methi is a dry curry made with potatoes and fenugreek leaves, seasoned with Indian spices. This dish is known for its unique bitter-sweet flavor from the methi leaves and is rich in nutrients.",
                new NutritionalInformation(165, 3, 28, 6)
        ));

        foodInfoMap.put("aloo sabji", new FoodDetails(
                "Aloo Sabji is a basic potato curry that's a staple in Indian households. Potatoes are cooked with onions, tomatoes, and basic Indian spices. It's a versatile dish that goes well with any Indian bread.",
                new NutritionalInformation(170, 3, 32, 5)
        ));

        foodInfoMap.put("aloo shimla mirch", new FoodDetails(
                "Aloo Shimla Mirch is a semi-dry curry made with potatoes and capsicum (bell peppers). This colorful dish combines the sweetness of peppers with spiced potatoes for a nutritious meal.",
                new NutritionalInformation(160, 3, 27, 6)
        ));

        foodInfoMap.put("bhatura", new FoodDetails(
                "Bhatura is a fluffy, deep-fried leavened bread from North India. It's typically served with chole (spiced chickpeas) and makes for a popular breakfast or lunch combination.",
                new NutritionalInformation(250, 6, 35, 12)
        ));

        foodInfoMap.put("bhindi masala", new FoodDetails(
                "Bhindi Masala is a spiced okra dish where the vegetables are cooked with onions, tomatoes, and aromatic spices. It's a popular side dish known for its unique texture and flavor.",
                new NutritionalInformation(140, 4, 15, 9)
        ));

        foodInfoMap.put("biryani", new FoodDetails(
                "Biryani is a fragrant rice dish made with aromatic basmati rice, spices, and either vegetables or meat. Each grain of rice is infused with flavor, making it one of India's most celebrated dishes.",
                new NutritionalInformation(350, 12, 45, 14)
        ));

        foodInfoMap.put("bisibelebath", new FoodDetails(
                "Bisibelebath is a spicy, rice-based dish from Karnataka made with dal, vegetables, and aromatic spices. It's a complete meal known for its unique spice blend and nutritious ingredients.",
                new NutritionalInformation(280, 8, 48, 7)
        ));

        foodInfoMap.put("butter", new FoodDetails(
                "Butter, or makhan, is a dairy product used extensively in Indian cooking. It adds richness to dishes and is often served with bread or used in cooking.",
                new NutritionalInformation(102, 0.1, 0, 11.5)
        ));

        foodInfoMap.put("butter chicken", new FoodDetails(
                "Butter Chicken is a creamy, tomato-based curry made with tender chicken pieces in a rich, buttery gravy. This popular dish is known for its mild, slightly sweet flavor and smooth texture.",
                new NutritionalInformation(320, 28, 8, 22)
        ));

        foodInfoMap.put("chana dal", new FoodDetails(
                "Chana Dal is a curry made from split Bengal gram, cooked with spices until soft. It's high in protein and fiber, making it a nutritious vegetarian dish.",
                new NutritionalInformation(230, 15, 35, 5)
        ));

        foodInfoMap.put("chana masala", new FoodDetails(
                "Chana Masala is a spiced chickpea curry popular across India. The chickpeas are cooked in a flavorful tomato-onion gravy with aromatic spices.",
                new NutritionalInformation(240, 11, 38, 6)
        ));

        foodInfoMap.put("chapati", new FoodDetails(
                "Chapati is a unleavened flatbread made from whole wheat flour. It's a staple bread in Indian cuisine, typically served with curries and vegetables.",
                new NutritionalInformation(120, 4, 20, 3)
        ));

        foodInfoMap.put("chicken tikka masala", new FoodDetails(
                "Chicken Tikka Masala consists of grilled chicken pieces in a rich, creamy tomato-based sauce. This popular dish combines tandoori cooking with a luxurious gravy.",
                new NutritionalInformation(325, 30, 10, 18)
        ));

        foodInfoMap.put("chutney", new FoodDetails(
                "Chutney is a condiment that can be made from various ingredients like mint, coconut, or tomatoes. It adds flavor and freshness to Indian meals.",
                new NutritionalInformation(50, 1, 10, 2)
        ));

        foodInfoMap.put("dosa", new FoodDetails(
                "Dosa is a crispy, fermented crepe made from rice and black gram batter. This South Indian breakfast staple is typically served with chutney and sambar.",
                new NutritionalInformation(135, 4, 25, 3)
        ));

        foodInfoMap.put("dum aloo", new FoodDetails(
                "Dum Aloo is a rich potato curry where baby potatoes are cooked in a thick, spiced gravy. The 'dum' cooking method allows the potatoes to absorb all the flavors.",
                new NutritionalInformation(220, 4, 35, 9)
        ));

        foodInfoMap.put("ghee", new FoodDetails(
                "Ghee is clarified butter used extensively in Indian cooking. It has a high smoke point and adds a distinct nutty flavor to dishes.",
                new NutritionalInformation(120, 0, 0, 13)
        ));

        foodInfoMap.put("gulab jamun", new FoodDetails(
                "Gulab Jamun is a sweet dessert of fried milk solids soaked in sugar syrup. These soft, syrupy balls are often flavored with cardamom and rose water.",
                new NutritionalInformation(175, 3, 25, 8)
        ));

        foodInfoMap.put("idli", new FoodDetails(
                "Idli is a steamed cake made from fermented rice and black gram batter. These light, fluffy breakfast items are naturally gluten-free and easily digestible.",
                new NutritionalInformation(85, 2, 15, 0.1)
        ));

        foodInfoMap.put("jalebi", new FoodDetails(
                "Jalebi is a spiral-shaped sweet made from fermented batter, deep-fried and soaked in sugar syrup. It's known for its crispy texture and sweet taste.",
                new NutritionalInformation(150, 2, 30, 5)
        ));

        foodInfoMap.put("kadai paneer", new FoodDetails(
                "Kadai Paneer is a semi-dry curry made with paneer (Indian cottage cheese) cooked with bell peppers in a spicy tomato-based gravy.",
                new NutritionalInformation(280, 14, 12, 22)
        ));

        foodInfoMap.put("naan", new FoodDetails(
                "Naan is a leavened, oven-baked flatbread. It's soft and fluffy, often brushed with butter, and serves as the perfect accompaniment to curries.",
                new NutritionalInformation(260, 9, 48, 3)
        ));

        foodInfoMap.put("palak paneer", new FoodDetails(
                "Palak Paneer is a vegetarian dish consisting of paneer in a thick paste made from pureed spinach. It's highly nutritious and popular across India.",
                new NutritionalInformation(250, 15, 10, 18)
        ));

        foodInfoMap.put("paneer butter masala", new FoodDetails(
                "Paneer Butter Masala is a rich curry made with paneer cubes in a creamy, tomato-based gravy. It's one of the most popular paneer preparations.",
                new NutritionalInformation(310, 16, 11, 24)
        ));

        foodInfoMap.put("pickle", new FoodDetails(
                "Indian pickle is a spicy, tangy condiment made by preserving vegetables or fruits in oil and spices. It adds a burst of flavor to meals.",
                new NutritionalInformation(60, 1, 8, 5)
        ));

        foodInfoMap.put("poha", new FoodDetails(
                "Poha is a light breakfast dish made from flattened rice flakes, typically cooked with onions, peanuts, and spices. It's quick to prepare and nutritious.",
                new NutritionalInformation(170, 4, 30, 6)
        ));

        foodInfoMap.put("pongal", new FoodDetails(
                "Pongal is a South Indian dish made from rice and split mung beans, cooked together and seasoned with pepper, cumin, and ghee.",
                new NutritionalInformation(250, 9, 45, 5)
        ));

        foodInfoMap.put("puri", new FoodDetails(
                "Puri is a deep-fried bread made from whole wheat flour that puffs up when fried. It's commonly served for breakfast or special occasions.",
                new NutritionalInformation(140, 3, 20, 5)
        ));

        foodInfoMap.put("ras malai", new FoodDetails(
                "Ras Malai is a sweet dessert consisting of soft paneer dumplings immersed in chilled, creamy milk flavored with cardamom and nuts.",
                new NutritionalInformation(186, 8, 20, 8)
        ));

        foodInfoMap.put("sambar", new FoodDetails(
                "Sambar is a lentil-based vegetable stew cooked with tamarind and a special spice blend. It's a staple accompaniment to South Indian dishes.",
                new NutritionalInformation(154, 6, 28, 3)
        ));

        foodInfoMap.put("shrikhand", new FoodDetails(
                "Shrikhand is a sweet dish made from strained yogurt, flavored with cardamom and saffron. It's creamy, rich, and often garnished with nuts.",
                new NutritionalInformation(220, 5, 25, 12)
        ));

        foodInfoMap.put("upma", new FoodDetails(
                "Upma is a savory breakfast dish made from dry roasted semolina cooked with vegetables and spices. It's light, nutritious, and easy to digest.",
                new NutritionalInformation(180, 5, 32, 5)
        ));


        // Adding food information to the HashMap
        foodInfoMap.put("adhirasam", new FoodDetails(
                "Adhirasam is a traditional South Indian sweet dish made from rice flour and jaggery (unrefined cane sugar). It is deep-fried to a golden brown color and often flavored with cardamom or other spices. Adhirasam is commonly prepared during festivals and special occasions.",
                new NutritionalInformation(150, 1, 35, 0.5)
        ));

        foodInfoMap.put("aloo gobi", new FoodDetails(
                "Aloo Gobi is a popular North Indian vegetarian dish made with potatoes (aloo) and cauliflower (gobi) cooked with various spices such as turmeric, cumin, and coriander. It's a flavorful and comforting dish often served with rice or bread.",
                new NutritionalInformation(200, 5, 30, 8)
        ));

        // Add information for other food items similarly...

        // Food item 3: Aloo Mtar
        foodInfoMap.put("aloo matar", new FoodDetails(
                "Aloo Matar is a classic Indian curry dish consisting of potatoes (aloo) and green peas (matar) cooked in a spiced tomato-based gravy. It's a simple yet delicious dish that pairs well with rice or Indian breads like roti or naan.",
                new NutritionalInformation(180, 4, 25, 7)
        ));

        // Food item 4: Aloo Methi
        foodInfoMap.put("aloo methi", new FoodDetails(
                "Aloo Methi is a nutritious and flavorful Indian dish made with potatoes (aloo) and fenugreek leaves (methi). The bitterness of the fenugreek leaves adds a unique taste to the dish, which is complemented by the spices used in its preparation.",
                new NutritionalInformation(170, 3, 25, 6)
        ));

        // Food item 5: Aloo Shimla Mirch
        foodInfoMap.put("aloo shimla mirch", new FoodDetails(
                "Aloo Shimla Mirch, also known as potato capsicum curry, is a simple yet delicious Indian dish made with potatoes (aloo) and bell peppers (Shimla Mirch). It's cooked in a tomato-based gravy with aromatic spices, making it a flavorful side dish.",
                new NutritionalInformation(160, 3, 20, 8)
        ));

        // Food item 6: Aloo Tikki
        foodInfoMap.put("aloo tikki", new FoodDetails(
                "Aloo Tikki is a popular Indian street food made from mashed potatoes (aloo) mixed with various spices, shaped into patties, and shallow fried until crispy. It's often served with chutneys or as a topping for chaat dishes.",
                new NutritionalInformation(100, 2, 15, 4)
        ));

        // Food item 7: Anarsa
        foodInfoMap.put("anarsa", new FoodDetails(
                "Anarsa is a traditional sweet snack from Maharashtra, India, made with rice flour, jaggery (or sugar), and sesame seeds. It has a crispy texture and is usually prepared during festivals like Diwali.",
                new NutritionalInformation(120, 2, 25, 2)
        ));

        // Food item 8: Appe
        foodInfoMap.put("appe", new FoodDetails(
                "Appe, also known as Paniyaram, is a popular South Indian snack made from a fermented batter of rice and lentils. These bite-sized dumplings are crispy on the outside and soft on the inside, often served with chutneys or sambar.",
                new NutritionalInformation(100, 3, 20, 1)
        ));

        // Food item 9: Ariselu
        foodInfoMap.put("ariselu", new FoodDetails(
                "Ariselu, also called Kajjaya, is a traditional sweet delicacy from Andhra Pradesh, made with rice flour, jaggery, and flavored with cardamom. These sweet treats are deep-fried to perfection and are popular during festivals like Sankranti.",
                new NutritionalInformation(150, 1, 30, 3)
        ));

        // Food item 10: Baati
        foodInfoMap.put("baati", new FoodDetails(
                "Baati is a popular Rajasthani dish made from whole wheat flour dough, shaped into balls, and baked or grilled until golden brown. It's often served with dal (lentil curry) and ghee (clarified butter), making it a hearty and nutritious meal.",
                new NutritionalInformation(250, 8, 40, 6)
        ));

        // Food item 11: Bandar Laddu
        foodInfoMap.put("bandar laddu", new FoodDetails(
                "Bandar Laddu is a famous sweet delicacy from Andhra Pradesh, India. It is made from roasted gram flour (besan), ghee (clarified butter), sugar, and flavored with cardamom. These laddus are usually spherical in shape and have a rich, melt-in-your-mouth texture.",
                new NutritionalInformation(150, 2, 20, 7)
        ));

        // Food item 12: Basundi
        foodInfoMap.put("basundi", new FoodDetails(
                "Basundi is a creamy and rich Indian dessert made by boiling milk with sugar until it is reduced to half its original volume. It is flavored with saffron, cardamom, and sometimes garnished with nuts like almonds and pistachios. Basundi is served chilled and is a popular sweet dish in Gujarat and Maharashtra.",
                new NutritionalInformation(200, 6, 30, 7)
        ));

        // Food item 13: Bhatura
        foodInfoMap.put("bhatura", new FoodDetails(
                "Bhatura is a deep-fried bread that is popular in North Indian cuisine, often served with Chole (spiced chickpea curry). It is made from fermented dough consisting of all-purpose flour, yogurt, and a leavening agent like baking powder or baking soda. Bhatura is soft, fluffy, and has a slight tangy flavor due to fermentation.",
                new NutritionalInformation(250, 5, 30, 12)
        ));

        // Food item 14: Bhindi Masala
        foodInfoMap.put("bhindi masala", new FoodDetails(
                "Bhindi Masala, also known as Okra Masala, is a popular vegetarian dish in Indian cuisine. It consists of tender okra (bhindi) cooked with onions, tomatoes, and a blend of spices such as turmeric, cumin, coriander, and chili powder. Bhindi Masala is flavorful, nutritious, and pairs well with rice or Indian breads.",
                new NutritionalInformation(120, 3, 15, 6)
        ));

        // Food item 15: Biryani
        foodInfoMap.put("biryani", new FoodDetails(
                "Biryani is a flavorful and aromatic rice dish cooked with spices, meat (such as chicken, lamb, or goat), or vegetables. It is a popular dish in Indian cuisine, known for its rich flavors and distinct cooking style, often accompanied by raita (yogurt sauce) or salad.",
                new NutritionalInformation(400, 25, 50, 15)
        ));

        // Food item 16: Boondi
        foodInfoMap.put("boondi", new FoodDetails(
                "Boondi is a popular Indian snack made from chickpea flour (besan) batter, which is fried into small, crispy, and round droplets. It can be seasoned with spices and often enjoyed as a standalone snack or used as an ingredient in various sweet and savory dishes.",
                new NutritionalInformation(150, 3, 20, 7)
        ));

        // Food item 17: Butter Chicken
        foodInfoMap.put("butter chicken", new FoodDetails(
                "Butter Chicken, also known as Murgh Makhani, is a rich and creamy chicken dish marinated in yogurt and spices, cooked in a tomato-based gravy enriched with butter, cream, and cashew paste. It is one of the most popular dishes in Indian cuisine, often served with naan or rice.",
                new NutritionalInformation(400, 30, 20, 30)
        ));

        // Food item 18: Chak Hao Kheer
        foodInfoMap.put("chak hao kheer", new FoodDetails(
                "Chak Hao Kheer is a traditional Manipuri rice pudding made from black glutinous rice, milk, sugar, and flavored with cardamom or other spices. It has a unique purple color and is often served as a dessert during festivals and special occasions.",
                new NutritionalInformation(200, 5, 40, 3)
        ));

        // Food item 19: Cham Cham
        foodInfoMap.put("cham cham", new FoodDetails(
                "Cham Cham is a popular Bengali sweet made from paneer (Indian cottage cheese) kneaded with sugar and flavored with saffron, cardamom, and rose water. These cylindrical-shaped sweets are usually soaked in sugar syrup and garnished with coconut flakes or nuts.",
                new NutritionalInformation(150, 3, 20, 6)
        ));

        // Food item 20: Chana Masala
        foodInfoMap.put("chana masala", new FoodDetails(
                "Chana Masala is a flavorful Indian curry made from chickpeas (chana) cooked with onions, tomatoes, and a blend of spices such as cumin, coriander, turmeric, and garam masala. It is a popular vegetarian dish often served with rice or Indian breads.",
                new NutritionalInformation(250, 10, 35, 8)
        ));


        // Adding food information to the HashMap
        foodInfoMap.put("chapati", new FoodDetails(
                "Chapati, also known as roti or phulka, is a staple Indian flatbread made from whole wheat flour. It is cooked on a griddle and often served hot, either plain or with ghee (clarified butter). Chapati is a common accompaniment to various Indian dishes.",
                new NutritionalInformation(70, 3, 15, 1)
        ));

        foodInfoMap.put("chicken rezala", new FoodDetails(
                "Chicken Rezala is a flavorful Bengali dish made with chicken cooked in a creamy white gravy flavored with yogurt, cashew paste, and aromatic spices such as cardamom, cinnamon, and nutmeg. It has a rich and mildly spicy taste, often served with rice or naan.",
                new NutritionalInformation(300, 20, 15, 25)
        ));

        foodInfoMap.put("chicken tikka", new FoodDetails(
                "Chicken Tikka is a popular Indian appetizer made from marinated pieces of chicken grilled or roasted in a tandoor (clay oven). The marinade typically includes yogurt, lemon juice, and a blend of spices, resulting in tender and flavorful chicken pieces.",
                new NutritionalInformation(200, 20, 10, 15)
        ));

        foodInfoMap.put("chicken tikka masala", new FoodDetails(
                "Chicken Tikka Masala is a classic Indian dish consisting of grilled or roasted chicken tikka cooked in a creamy tomato-based sauce flavored with spices such as garam masala, cumin, and fenugreek. It is rich, flavorful, and often served with rice or naan.",
                new NutritionalInformation(300, 20, 15, 20)
        ));

        foodInfoMap.put("chikki", new FoodDetails(
                "Chikki is a popular Indian sweet made from jaggery (or sugar) and peanuts or sesame seeds. It is crunchy, sweet, and often flavored with cardamom or other spices. Chikki comes in various forms and is enjoyed as a snack.",
                new NutritionalInformation(150, 3, 20, 7)
        ));

        foodInfoMap.put("churma", new FoodDetails(
                "Churma is a traditional Rajasthani sweet dish made from coarsely ground wheat flour, ghee, and sugar or jaggery. It is often flavored with cardamom and shaped into small balls, then served with ghee or topped with nuts.",
                new NutritionalInformation(200, 2, 30, 8)
        ));

        foodInfoMap.put("daal", new FoodDetails(
                "Daal, or lentils, are a staple food in Indian cuisine. They are cooked with various spices and can be made into a thick stew-like consistency or a soup. Daal is rich in protein and fiber and is often served with rice or bread.",
                new NutritionalInformation(150, 10, 20, 2)
        ));

        foodInfoMap.put("daal puri", new FoodDetails(
                "Daal Puri is a popular Indian flatbread stuffed with a spiced mixture of cooked lentils (daal). The dough is rolled out, filled with the daal mixture, and then fried until golden brown and crispy. It is often served as a snack or breakfast item.",
                new NutritionalInformation(150, 5, 20, 6)
        ));

        foodInfoMap.put("dal makhani", new FoodDetails(
                "Dal Makhani is a creamy and rich lentil dish made from black lentils (urad dal) and kidney beans (rajma), cooked with butter, cream, and aromatic spices. It is a popular dish in North Indian cuisine, often served with rice or naan.",
                new NutritionalInformation(400, 20, 40, 20)
        ));

        foodInfoMap.put("dal tadka", new FoodDetails(
                "Dal Tadka is a flavorful Indian lentil dish made from cooked lentils tempered with ghee, cumin seeds, garlic, and spices such as turmeric and red chili powder. It is a comforting and nutritious dish often served with rice or bread.",
                new NutritionalInformation(250, 15, 25, 10)
        ));

        foodInfoMap.put("dharwad pedha", new FoodDetails(
                "Dharwad Pedha is a famous sweet delicacy from the city of Dharwad in Karnataka, India. It is made from khoa (reduced milk), sugar, and flavored with cardamom. Dharwad Pedha has a rich, caramel-like taste and a soft, fudge-like texture.",
                new NutritionalInformation(100, 3, 15, 4)
        ));

        foodInfoMap.put("doodhpak", new FoodDetails(
                "Doodhpak is a creamy and rich rice pudding made with milk, rice, sugar, and flavored with cardamom, saffron, and nuts. It is a popular dessert in Gujarati cuisine, often served during festivals and special occasions.",
                new NutritionalInformation(250, 6, 40, 8)
        ));

        foodInfoMap.put("double ka meetha", new FoodDetails(
                "Double Ka Meetha is a popular Hyderabadi dessert made from bread slices fried in ghee and soaked in sugar syrup, flavored with cardamom, saffron, and garnished with nuts. It is a rich and indulgent sweet dish often served during festivals and celebrations.",
                new NutritionalInformation(300, 4, 40, 15)
        ));

        foodInfoMap.put("dum aloo", new FoodDetails(
                "Dum Aloo is a delicious North Indian potato curry made with baby potatoes cooked in a spiced tomato-based gravy, flavored with yogurt, cream, and aromatic spices. It is a flavorful and comforting dish often served with rice or Indian breads.",
                new NutritionalInformation(250, 5, 30, 12)
        ));

        foodInfoMap.put("gajar halwa", new FoodDetails(
                "Gajar Halwa, also known as Carrot Halwa, is a popular Indian dessert made from grated carrots cooked with milk, sugar, ghee, and flavored with cardamom, saffron, and nuts. It is rich, creamy, and often served warm during festivals and special occasions.",
                new NutritionalInformation(250, 4, 35, 10)
        ));

        foodInfoMap.put("gavvalu", new FoodDetails(
                "Gavvalu, also known as kodi gavvalu, is a traditional Andhra snack made from rice flour and shaped like cowrie shells. These crispy and crunchy snacks are often sweetened with jaggery and flavored with cardamom or sesame seeds.",
                new NutritionalInformation(100, 2, 20, 2)
        ));

        foodInfoMap.put("ghevar", new FoodDetails(
                "Ghevar is a popular Rajasthani sweet made from flour, ghee, and sugar syrup. It is deep-fried and then soaked in sugar syrup, resulting in a crispy and sweet dessert. Ghevar is often enjoyed during festivals like Teej and Raksha Bandhan.",
                new NutritionalInformation(200, 2, 30, 8)
        ));

        foodInfoMap.put("gulab jamun", new FoodDetails(
                "Gulab Jamun is a classic Indian sweet made from khoya (reduced milk) or milk powder, fried into small balls and soaked in sugar syrup flavored with rose water, cardamom, or saffron. It has a soft, melt-in-your-mouth texture and is often served warm.",
                new NutritionalInformation(150, 2, 20, 7)
        ));

        foodInfoMap.put("imarti", new FoodDetails(
                "Imarti is a traditional Indian sweet made from urad dal batter, which is deep-fried in a spiral shape and soaked in sugar syrup. It is similar to jalebi but has a distinct shape and texture. Imarti is often enjoyed during festivals and special occasions.",
                new NutritionalInformation(200, 2, 30, 8)
        ));

        foodInfoMap.put("jalebi", new FoodDetails(
                "Jalebi is a popular Indian sweet made by deep-frying a fermented batter of refined flour (maida) into pretzel-like shapes, which are then soaked in sugar syrup. Jalebi has a crispy texture and is often enjoyed hot or cold.",
                new NutritionalInformation(150, 1, 30, 3)
        ));

        foodInfoMap.put("kachori", new FoodDetails(
                "Kachori is a savory Indian pastry filled with a spicy mixture of lentils, peas, or potatoes, flavored with spices like cumin, coriander, and chili. It is deep-fried until golden brown and crispy, often served with chutney or curry.",
                new NutritionalInformation(200, 4, 20, 12)
        ));


        // Adding food information to the HashMap
        foodInfoMap.put("kadai paneer", new FoodDetails(
                "Kadai Paneer is a popular North Indian curry made with paneer (Indian cottage cheese), bell peppers, onions, and tomatoes, cooked in a spiced gravy flavored with kadai masala. It is a flavorful and aromatic dish often served with naan or rice.",
                new NutritionalInformation(300, 15, 10, 20)
        ));

        foodInfoMap.put("kadhi pakoda", new FoodDetails(
                "Kadhi Pakoda is a yogurt-based curry with fried chickpea flour (besan) dumplings. The curry is flavored with spices such as turmeric, cumin, and fenugreek seeds. It is a comforting and flavorful dish often served with rice or roti.",
                new NutritionalInformation(250, 8, 20, 15)
        ));

        foodInfoMap.put("kakinada khaja", new FoodDetails(
                "Kakinada Khaja is a popular Andhra sweet made with refined flour, sugar, and ghee. It is deep-fried until crispy and then soaked in sugar syrup. Kakinada Khaja has layers and is often enjoyed as a dessert.",
                new NutritionalInformation(200, 2, 30, 8)
        ));

        foodInfoMap.put("kalakand", new FoodDetails(
                "Kalakand is a traditional Indian sweet made from condensed milk and paneer (Indian cottage cheese), cooked until it solidifies, and then flavored with cardamom and garnished with nuts. It has a rich and creamy texture, often served during festivals and celebrations.",
                new NutritionalInformation(200, 5, 25, 10)
        ));

        foodInfoMap.put("karela bharta", new FoodDetails(
                "Karela Bharta is a North Indian dish made with bitter gourd (karela) that is roasted or fried until tender and then mashed. It is seasoned with spices like cumin, coriander, and chili powder, resulting in a flavorful and nutritious side dish.",
                new NutritionalInformation(100, 3, 10, 6)
        ));

        foodInfoMap.put("kheer", new FoodDetails(
                "Kheer is a creamy and delicious Indian rice pudding made with milk, rice, sugar, and flavored with cardamom, saffron, and nuts. It is often served as a dessert during festivals and special occasions.",
                new NutritionalInformation(200, 5, 30, 7)
        ));

        foodInfoMap.put("kofta", new FoodDetails(
                "Kofta is a popular Indian dish consisting of spiced meatballs or vegetable balls cooked in a flavorful gravy. The koftas can be made from minced meat, paneer, or vegetables like potatoes, spinach, or bottle gourd.",
                new NutritionalInformation(0, 0, 0, 0) // Varies based on ingredients
        ));

        foodInfoMap.put("lassi", new FoodDetails(
                "Lassi is a refreshing yogurt-based drink popular in India. It can be sweet or savory, flavored with fruits, spices, or herbs. Sweet lassi is made with yogurt, sugar, and flavored with cardamom or rose water, while savory lassi is seasoned with salt and spices.",
                new NutritionalInformation(150, 6, 20, 5)
        ));

        foodInfoMap.put("ledikeni", new FoodDetails(
                "Ledikeni is a famous Bengali sweet made from khoya (reduced milk), sugar, and flavored with cardamom. The dough is shaped into cylindrical dumplings, fried until golden brown, and then soaked in sugar syrup.",
                new NutritionalInformation(100, 2, 15, 4)
        ));

        foodInfoMap.put("litti chokha", new FoodDetails(
                "Litti Chokha is a traditional dish from Bihar, India, consisting of wheat flour dumplings stuffed with spiced roasted gram flour (sattu), and then baked or grilled. It is served with chokha, a spicy mashed vegetable mix typically made from roasted eggplant, tomatoes, and spices.",
                new NutritionalInformation(200, 8, 30, 5)
        ));

        foodInfoMap.put("lyangcha", new FoodDetails(
                "Lyangcha is a popular sweet from West Bengal, made from deep-fried dough soaked in sugar syrup. It has a crispy exterior and a soft, syrupy interior. Lyangcha is often flavored with cardamom and sometimes coated with coconut or sesame seeds.",
                new NutritionalInformation(150, 2, 25, 6)
        ));

        foodInfoMap.put("maach jhol", new FoodDetails(
                "Maach Jhol is a traditional Bengali fish curry made with fish (usually freshwater fish like rohu or hilsa), potatoes, tomatoes, and spices. It is cooked in a flavorful gravy seasoned with mustard oil, cumin seeds, and green chilies.",
                new NutritionalInformation(200, 20, 10, 10)
        ));

        foodInfoMap.put("makki di roti sarso ka saag", new FoodDetails(
                "Makki Di Roti Sarso Ka Saag is a traditional Punjabi dish consisting of cornmeal flatbread (makki di roti) served with mustard greens (sarso ka saag). The saag is cooked with spices, ginger, garlic, and often served with a dollop of butter or ghee.",
                new NutritionalInformation(250, 5, 40, 8)
        ));

        foodInfoMap.put("malpua", new FoodDetails(
                "Malpua is a sweet Indian pancake made from flour, milk, and sugar, flavored with cardamom, saffron, and sometimes fennel seeds. It is fried until golden brown and then dipped in sugar syrup. Malpua is often served as a dessert during festivals like Holi.",
                new NutritionalInformation(200, 3, 30, 8)
        ));

        foodInfoMap.put("misi roti", new FoodDetails(
                "Misi Roti is a type of Indian flatbread made from a combination of wheat flour and gram flour (besan). It is flavored with spices like cumin, coriander, and ajwain seeds, giving it a unique taste. Misi Roti is often served with curry or yogurt.",
                new NutritionalInformation(150, 5, 25, 4)
        ));

        foodInfoMap.put("misti doi", new FoodDetails(
                "Mishti Doi, also known as sweet yogurt, is a popular Bengali dessert made from fermented sweetened yogurt. It is traditionally set in earthen pots, which imparts a unique flavor to the dessert. Mishti Doi is creamy, rich, and mildly sweet.",
                new NutritionalInformation(150, 6, 20, 5)
        ));

        foodInfoMap.put("modak", new FoodDetails(
                "Modak is a sweet dumpling popular in Maharashtra, India, especially during the festival of Ganesh Chaturthi. It is made from rice flour dough filled with a sweet mixture of jaggery, coconut, and cardamom, then steamed or fried.",
                new NutritionalInformation(100, 2, 20, 3)
        ));

        foodInfoMap.put("mysore pak", new FoodDetails(
                "Mysore Pak is a famous South Indian sweet made from gram flour (besan), sugar, and ghee (clarified butter). It has a rich, melt-in-your-mouth texture and is often flavored with cardamom.",
                new NutritionalInformation(200, 2, 25, 12)
        ));

        foodInfoMap.put("naan", new FoodDetails(
                "Naan is a popular Indian flatbread made from white flour, yeast, yogurt, and milk. It is traditionally cooked in a tandoor (clay oven) and often brushed with ghee or butter before serving. Naan is a versatile accompaniment to various Indian dishes.",
                new NutritionalInformation(250, 8, 40, 6)
        ));

        foodInfoMap.put("navrattan porma", new FoodDetails(
                "Navrattan Korma is a rich and creamy Mughlai dish made with nine different types of vegetables, nuts, and paneer (Indian cottage cheese), cooked in a spiced gravy made from yogurt, cream, and various spices. It is a flavorful vegetarian option in Indian cuisine.",
                new NutritionalInformation(300, 8, 20, 20)
        ));

        // Adding food information to the HashMap
        foodInfoMap.put("palak paneer", new FoodDetails(
                "Palak Paneer is a popular North Indian dish made with spinach (palak) and paneer (Indian cottage cheese), cooked in a flavorful gravy of onions, tomatoes, and spices. It is a nutritious and delicious vegetarian option often served with rice or naan.",
                new NutritionalInformation(250, 15, 10, 18)
        ));

        foodInfoMap.put("paneer butter masala", new FoodDetails(
                "Paneer Butter Masala is a creamy and indulgent North Indian dish made with paneer (Indian cottage cheese) cooked in a rich tomato-based gravy, flavored with butter, cream, and aromatic spices. It is a popular vegetarian option in Indian restaurants.",
                new NutritionalInformation(350, 12, 15, 25)
        ));

        foodInfoMap.put("phirni", new FoodDetails(
                "Phirni is a creamy Indian rice pudding made with ground rice, milk, sugar, and flavored with cardamom, saffron, and nuts. It is typically served chilled and is a popular dessert during festivals and special occasions.",
                new NutritionalInformation(200, 4, 30, 8)
        ));

        foodInfoMap.put("pithe", new FoodDetails(
                "Pithe is a traditional Bengali sweet dish made during festivals like Makar Sankranti. It includes various types of rice flour-based cakes, often filled with sweetened coconut or jaggery, and can be fried, steamed, or baked.",
                new NutritionalInformation(100, 1, 20, 3)
        ));

        foodInfoMap.put("poha", new FoodDetails(
                "Poha, also known as flattened rice, is a popular breakfast dish in India. It is made by flattening rice and then dry roasting or cooking it with onions, peas, peanuts, and spices. Poha is light, nutritious, and often enjoyed with a squeeze of lemon juice.",
                new NutritionalInformation(150, 3, 30, 1)
        ));

        foodInfoMap.put("poornalu", new FoodDetails(
                "Poornalu is a traditional sweet snack from Andhra Pradesh, made with a dough of rice flour, jaggery, and lentils, filled with a sweet mixture of grated coconut and jaggery, and deep-fried until golden brown.",
                new NutritionalInformation(100, 1, 15, 5)
        ));

        foodInfoMap.put("pootharekulu", new FoodDetails(
                "Pootharekulu is a traditional sweet from Andhra Pradesh, India. It is made from rice starch, sugar, ghee, and sometimes cardamom. Pootharekulu is known for its delicate and paper-thin layers, making it a unique and delightful dessert.",
                new NutritionalInformation(100, 1, 15, 4)
        ));

        foodInfoMap.put("qubani ka meetha", new FoodDetails(
                "Qubani Ka Meetha is a popular Hyderabadi dessert made from dried apricots (qubani) cooked in sugar syrup until they are soft and pulpy. It is often flavored with cardamom and garnished with almonds or pistachios.",
                new NutritionalInformation(200, 2, 40, 5)
        ));

        foodInfoMap.put("rabri", new FoodDetails(
                "Rabri is a sweet and creamy dessert from North India made by simmering milk for a long time until it thickens and reduces to a creamy consistency. It is often flavored with saffron, cardamom, and garnished with nuts.",
                new NutritionalInformation(250, 8, 30, 12)
        ));

        foodInfoMap.put("ras malai", new FoodDetails(
                "Ras Malai is a popular Bengali dessert made from soft paneer (Indian cottage cheese) balls soaked in sweetened, thickened milk flavored with cardamom, saffron, and sometimes rose water. It is served chilled and garnished with chopped nuts.",
                new NutritionalInformation(250, 8, 20, 15)
        ));

        foodInfoMap.put("rasgulla", new FoodDetails(
                "Rasgulla is a traditional Bengali sweet made from soft and spongy cottage cheese (chhena) balls cooked in sugar syrup. It is light, airy, and has a delicate sweetness, making it a popular dessert in Indian cuisine.",
                new NutritionalInformation(150, 5, 30, 2)
        ));

        foodInfoMap.put("sandesh", new FoodDetails(
                "Sandesh is a popular Bengali sweet made from fresh paneer (chhena) mixed with sugar and flavored with cardamom, saffron, or fruits like mango or pineapple. It is often shaped into various decorative molds and enjoyed as a dessert.",
                new NutritionalInformation(100, 4, 15, 4)
        ));

        foodInfoMap.put("shankarpali", new FoodDetails(
                "Shankarpali, also known as Shakarpara, is a popular Indian snack made from a dough of flour, sugar, ghee, and flavored with cardamom. The dough is rolled out, cut into diamond shapes, and deep-fried until crispy.",
                new NutritionalInformation(150, 2, 20, 7)
        ));

        foodInfoMap.put("sheera", new FoodDetails(
                "Sheera, also known as Sooji Halwa or Semolina Pudding, is a sweet dish made from semolina (sooji), sugar, ghee, and flavored with cardamom and nuts. It is commonly prepared as a prasad (offering) during religious ceremonies and festivals.",
                new NutritionalInformation(200, 3, 25, 10)
        ));

        foodInfoMap.put("shrikhand", new FoodDetails(
                "Shrikhand is a creamy and sweet yogurt-based dessert from Western India, particularly popular in Maharashtra and Gujarat. It is made by straining yogurt to remove the whey, then sweetening it with sugar and flavoring it with cardamom, saffron, or nuts.",
                new NutritionalInformation(150, 6, 20, 5)
        ));

        foodInfoMap.put("gujia", new FoodDetails(
                "Gujia is a popular sweet dumpling from North India, often made during festivals like Holi. It is made by filling a mixture of khoya (reduced milk), dried fruits, and nuts into a thin pastry shell, which is then folded into a crescent shape and deep-fried until golden brown.",
                new NutritionalInformation(200, 8, 25, 10)
        ));

        foodInfoMap.put("soan papdi", new FoodDetails(
                "Soan Papdi is a popular Indian sweet made from chickpea flour (besan), sugar, ghee, and flavored with cardamom. It has a flaky and melt-in-your-mouth texture, often enjoyed during festivals and celebrations.",
                new NutritionalInformation(100, 1, 20, 3)
        ));

        foodInfoMap.put("sohan halwa", new FoodDetails(
                "Sohan Halwa is a traditional sweet from the Indian subcontinent made from wheat flour, sugar, ghee, and flavored with saffron, cardamom, and nuts. It has a rich and dense texture, often enjoyed during festivals and special occasions.",
                new NutritionalInformation(200, 2, 30, 8)
        ));

        foodInfoMap.put("sutar feni", new FoodDetails(
                "Sutar Feni is a traditional Goan sweet made from thin strands of dough that are fried until crisp and then soaked in sugar syrup. It is often flavored with cardamom and garnished with nuts.",
                new NutritionalInformation(150, 1, 25, 5)
        ));

        foodInfoMap.put("unni appam", new FoodDetails(
                "Unni Appam is a traditional South Indian sweet made from rice flour, jaggery, banana, coconut, and flavored with cardamom. The batter is poured into a special pan with small cavities and fried until golden brown.",
                new NutritionalInformation(100, 1, 15, 4)
        ));


//        // Get and process information for a specific food item (e.g., Aloo Gobi)
//        FoodDetails alooGobiDetails = foodInfoMap.get("Aloo Gobi");
//        if (alooGobiDetails != null) {
//            String description = alooGobiDetails.getDescription();
//            NutritionalInformation nutritionalInfo = alooGobiDetails.getNutritionalInformation();
//
//            System.out.println("Description for Aloo Gobi:\n" + description);
//            System.out.println("Nutritional Information:\n" +
//                    "Calories: " + nutritionalInfo.getCalories() + " kcal\n" +
//                    "Protein: " + nutritionalInfo.getProtein() + "g\n" +
//                    "Carbohydrates: " + nutritionalInfo.getCarbohydrates() + "g\n" +
//                    "Fat: " + nutritionalInfo.getFat() + "g");
//        }


        return foodInfoMap;
    }

}