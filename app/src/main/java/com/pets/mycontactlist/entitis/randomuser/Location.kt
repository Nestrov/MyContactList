package com.pets.mycontactlist.entitis.randomuser

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city") val city: String,
    @SerializedName("coordinates") val coordinates: Coordinates,
    @SerializedName("country") val country: String,
    @SerializedName("postcode") val postcode: String,
    @SerializedName("state") val state: String,
    @SerializedName("street") val street: Street,
    @SerializedName("timezone") val timezone: Timezone
)

fun Location.toUserInfoAddress() : String{
    var res: String = postcode
    if (country.isNotEmpty()) res += " $country"
    if (city.isNotEmpty()) res += " $city"
    if (street.name.isNotEmpty()) res += " ${street.name}"

    return res
}