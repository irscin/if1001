package com.example.if1001.firebase

import com.example.if1001.models.DishModel
import com.example.if1001.models.RatingModel
import com.example.if1001.models.RestaurantModel
import com.google.firebase.database.*
import com.google.firebase.database.FirebaseDatabase

class FirebaseManager() {
    // A reference to the database root (/)

    private var rootReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    fun loadDatabase() : ArrayList<RestaurantModel> {
        // Dishes
        val dishA = DishModel(
            name = "Combinado de Sushi 30 pcs",
            price = 30.50,
            rating = 4
        )

        val dishB = DishModel(
            name = "Combinado de Sushi 60 pcs",
            price = 45.90,
            rating = 3
        )

        val dishC = DishModel(
            name = "Temaki Promocional",
            price = 9.90,
            rating = 3
        )

        val dishD = DishModel(
            name = "Pizza Grande Premium",
            price = 45.90,
            rating = 5
        )

        val dishE = DishModel(
            name = "Pizza Média Tradicional",
            price = 40.90,
            rating = 2
        )

        val dishF = DishModel(
            name = "X-Bacon Maroto",
            price = 25.90,
            rating = 5
        )

        val dishG = DishModel(
            name = "Beirute Monstrão",
            price = 35.99,
            rating = 4
        )

        // Restaurants
        val restaurantA = RestaurantModel(
            name = "Natsu Sushi",
            address = "R. Alexandre Kruse Filho - Caxangá, Recife - PE, 50980-565",
            rating = arrayListOf(
                RatingModel(4, "Melhor sushi da região"),
                RatingModel(4, "Poderia melhorar o preço do sushi"),
                RatingModel(2, "É bom, porem as peças são pequenas"),
                RatingModel(2, "Poderia melhorar muito o serviço"),
                RatingModel(1, "Achei uma barata no meu sushi")
            ),
            about = "Restaurante completo com sushis, sashimis e temakis",
            coords = hashMapOf(
                "lat" to -8.0267835,
                "long" to -34.9629441
            ),
            menu = arrayListOf(
                dishA,
                dishB,
                dishC
            )
        )

        val restaurantB = RestaurantModel(
            name = "Pizzaria Domino\'s",
            address = "Av. Caxangá, 3210 - Iputinga, Recife - PE, 50731-000",
            rating = arrayListOf(
                    RatingModel(5, "Muito boa a promoção 2x1"),
                    RatingModel(4, "Boa, porém cara"),
                    RatingModel(3, "Pizza veio fria"),
                    RatingModel(2, "Horrível, demorou 3 horas para entregar"),
            ),
            about = "Franquia local da Domino's Pizza",
            coords = hashMapOf(
                "lat" to -8.0476386,
                "long" to -34.9369254
            ),
            menu = arrayListOf(
                dishD,
                dishE
            )
        )

        val restaurantC = RestaurantModel(
            name = "Burger Grill Várzea",
            address = "R. Gen. Polidoro, 681 - Várzea, Recife - PE, 50740-050",
            rating = arrayListOf(
                RatingModel(5, "O hamburguer de carne de sol é ótimo"),
                RatingModel(5, "Adorei o Beirute"),
                RatingModel(3, "Ok pelo preço"),
                RatingModel(3, "Esqueceram dos sachês de ketchup"),
                RatingModel(4, "Bom custo benefício"),
                RatingModel(1, "Usaram queijo estragado no lanche"),
            ),
            about = "Hamburgueria acessível da Várzea",
            coords = hashMapOf(
                "lat" to -8.0425605,
                "long" to -34.9434915
            ),
            menu = arrayListOf(
                dishF,
                dishG
            )
        )

        val availableRestaurants = arrayListOf(
            restaurantA,
            restaurantB,
            restaurantC
        )

        for(restaurant in availableRestaurants) {
            val restaurantKey = rootReference.child("restaurants").push().key
            restaurant.uuid = restaurantKey.toString()
            rootReference.child("restaurants").child(restaurant.uuid).setValue(restaurant)
        }

        return availableRestaurants
    }

}