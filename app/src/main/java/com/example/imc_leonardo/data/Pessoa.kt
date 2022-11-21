package com.example.imc_leonardo.data

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class Pessoa() : Parcelable {
    var Nome  : String= ""
    var Altura: Double = 0.0
    var Peso: Double = 0.0
    var Adulto: Boolean = true;

    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this() {
        Nome = parcel.readString().toString()
        Altura = parcel.readDouble()
        Peso = parcel.readDouble()
        Adulto = parcel.readBoolean()
    }

    public fun RetornarIMC() :Double{
        return Peso / (Altura * Altura)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Nome)
        parcel.writeDouble(Altura)
        parcel.writeDouble(Peso)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeBoolean(Adulto)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pessoa> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Pessoa {
            return Pessoa(parcel)
        }

        override fun newArray(size: Int): Array<Pessoa?> {
            return arrayOfNulls(size)
        }
    }
}

