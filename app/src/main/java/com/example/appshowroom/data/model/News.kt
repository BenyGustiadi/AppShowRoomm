package com.example.appshowroom.data.model

import android.os.Parcel
import android.os.Parcelable

data class News(
    val Make_Id: Int = 0,
    val Make_Name: String? = "",
    val Model_Id: Int = 0,
    val Model_Name: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Make_Id)
        parcel.writeString(Make_Name)
        parcel.writeInt(Model_Id)
        parcel.writeString(Model_Name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<News> {
        override fun createFromParcel(parcel: Parcel): News {
            return News(parcel)
        }

        override fun newArray(size: Int): Array<News?> {
            return arrayOfNulls(size)
        }
    }

}
