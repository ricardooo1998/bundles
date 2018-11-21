package com.tema3.ricardo.bundles;

import android.os.Parcel;
import android.os.Parcelable;

public class Personas implements Parcelable {
    private String userId;
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasenia;
    private String telefono;

    public Personas()
    {

    }

    public Personas(String id, String n, String a, String e, String con, String t) {
        userId=id;
        nombre=n;
        apellidos=a;
        email=e;
        contrasenia=con;
        telefono=t;
    }

    protected Personas(Parcel in) {
        userId = in.readString();
        nombre = in.readString();
        apellidos = in.readString();
        email = in.readString();
        contrasenia = in.readString();
        telefono = in.readString();
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userId);
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeString(email);
        dest.writeString(contrasenia);
        dest.writeString(telefono);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Personas> CREATOR = new Parcelable.Creator<Personas>() {
        @Override
        public Personas createFromParcel(Parcel in) {
            return new Personas(in);
        }

        @Override
        public Personas[] newArray(int size) {
            return new Personas[size];
        }
    };
}
