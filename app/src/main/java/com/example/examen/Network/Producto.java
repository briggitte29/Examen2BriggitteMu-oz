package com.example.examen.Network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.examen.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Producto {
private static final String TAG=Producto.class.getCanonicalName();
    public final String  imageUrl;
    public final String nombre;
    public final Uri dynamicUrl;

 public Producto(String imageUrl, String nombre, String dynamicUrl){
     this.imageUrl=imageUrl;
     this.nombre=nombre;
     this.dynamicUrl=Uri.parse(dynamicUrl);
 }

 public static List<Producto> initProductoList(Resources resources){
     InputStream inputStream=resources.openRawResource(R.raw.product);
     Writer writer=new StringWriter();
     char[] buffer=new char[1024];

     try {
         Reader reader=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
         int pointer;
         while ((pointer=reader.read(buffer))!=-1){
             writer.write(buffer,0,pointer);
         }
     }catch (IOException IOX){
         Log.e(TAG,"Error al escribir o leer el archivo JSON",IOX);
     }finally {
         try {
             inputStream.close();
         }catch (IOException IO){
             Log.e(TAG,"Error al cerra la conexion con el archivo",IO);
         }
     }

     String jsonProductoString=writer.toString();
     Gson gson=new Gson();
     Type productoListType=new TypeToken<ArrayList<Producto>>(){

     }.getType();

    return gson.fromJson(jsonProductoString,productoListType);

 }

}
