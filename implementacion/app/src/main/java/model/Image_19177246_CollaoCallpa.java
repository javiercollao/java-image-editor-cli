/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Javier Collao
 */
public class Image_19177246_CollaoCallpa implements IImage_19177246_CollaoCallpa {
    public int width;
    public int height;
    public List<Pixel_19177246_CollaoCallpa> pixels;

    public Image_19177246_CollaoCallpa(int width, int height, List<Pixel_19177246_CollaoCallpa> pixels) {
        this.width = width;
        this.height = height;
        this.pixels = pixels;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Pixel_19177246_CollaoCallpa> getPixels() {
        return pixels;
    }

    public void setPixels(List<Pixel_19177246_CollaoCallpa> pixels) {
        this.pixels = pixels;
    }
    
    /* Descripción: función que permite determinar si la imagen corresponde a un bitmap-d.*/
    @Override
    public boolean isBitmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isBit());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }
    /*   */
    @Override
    public boolean isPixmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isPix());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }

    /*   */
    @Override
    public boolean isHexmap() {
        boolean result;
        List<Boolean> lista = new ArrayList<>();
        
        this.pixels.forEach(element -> {
            lista.add(element.isHex());
        });
        
        if(lista.contains(false)){
            result = false;
        }else{
            result = true;
        }
        
        return result;
    }

    /*   */
    @Override
    public boolean isCompressed() {
        return false;
    }

    /* Descripción: función que permite invertir una imágen horizontalmente.  */
    @Override
    public void flipH() {
        int width = this.getWidth()-1;
        this.pixels.forEach(pixel -> {
            if(pixel.getPosX() == width){
                pixel.setPosX(0);
            }else if(pixel.getPosX() == 0){
                pixel.setPosX(width);
            }else{
                pixel.setPosX(width-pixel.getPosX());
            }
        }); 
    }

    /*  Descripción: función que permite invertir una imágen verticalmente.  */
    @Override
    public void flipV() {
        int height = this.getHeight()-1;
        this.pixels.forEach(pixel -> {
            if(pixel.getPosY() == height){
                pixel.setPosY(0);
            }else if(pixel.getPosY() == 0){
                pixel.setPosY(height);
            }else{
                pixel.setPosY(height-pixel.getPosY());
            }
        }); 
    }

    /*  Descripción: Recortar una imágen a partir de un cuadrante.  */
    @Override
    public void crop(int x1, int y1, int x2, int y2) {
        List<Pixel_19177246_CollaoCallpa> lista = new ArrayList<>();
        this.pixels.forEach(pixel -> {
            if(pixel.getPosX() >= x1 && pixel.getPosX() <= x2 && pixel.getPosY()<= y1){
                lista.add(pixel);
            }else{
                lista.add(null);
            }
        });
        lista.removeIf(pixel -> (pixel == null));
        this.setPixels(lista);
        this.setWidth((x2-x1)+1);
        this.setHeight(this.height-((this.height-1)-y2));
    }

    /* Descripción: Transforma una imagen desde una representación RGB a una representación HEX.  */
    @Override
    public void imgRGBToHex() {
        List<Pixel_19177246_CollaoCallpa> lista = new ArrayList<>();
        if(this.isPixmap()){
            this.pixels.forEach(pixel -> {
                Pixel_19177246_CollaoCallpa p = new Pixhex_19177246_CollaoCallpa(pixel.getPosX(),pixel.getPosY(), pixel.rgbToHex(), pixel.getDepth());
                lista.add(p);
            });
            this.setPixels(lista);
        }else{
            this.setPixels(this.pixels);
        }
    }

    /*  Descripción: Retorna un histograma de frecuencias a partir de los colores en cada una de las imágenes. Debe funcionar para bitmap-d, pixmap-d y hexmap-d. */
    @Override
    public Histogram_19177246_CollaoCallpa histogram() { 
        List<HistogramColor_19177246_CollaoCallpa> listaFrencuenciaColores = null;
        if(this.isBitmap()){  
            List<Integer> colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                int bit = ((Pixbit_19177246_CollaoCallpa)pixel).getBit();
                colors.add(bit);
            });
            listaFrencuenciaColores = filterBit(colors);
        }else if(this.isPixmap()){
            List<List<Integer>> colors;
            colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                List<Integer> color = ((Pixrgb_19177246_CollaoCallpa)pixel).getRGB();
                colors.add(color);
            }); 
            listaFrencuenciaColores = filterRgb(colors);
        }else{
            List<String> colors;
            colors = new ArrayList<>();
            this.pixels.forEach(pixel -> {
                String hex = ((Pixhex_19177246_CollaoCallpa)pixel).getHex();
                colors.add(hex);
            }); 
            listaFrencuenciaColores = filterHex(colors);
        }
        Histogram_19177246_CollaoCallpa histo;
        histo = new Histogram_19177246_CollaoCallpa(listaFrencuenciaColores);
        return histo;  
    }
    
    public List<HistogramColor_19177246_CollaoCallpa> filterBit(List<Integer> lista){
        List<HistogramColor_19177246_CollaoCallpa> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorBit_19177246_CollaoCallpa colorBit;
            colorBit = new HistogramColorBit_19177246_CollaoCallpa(lista.get(i),count); 
            histo.add(colorBit);
        }
       
        return histo;
    }
    
    public List<HistogramColor_19177246_CollaoCallpa> filterRgb(List<List<Integer>> lista){
        List<HistogramColor_19177246_CollaoCallpa> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorRgb_19177246_CollaoCallpa colorRgb;
            colorRgb = new HistogramColorRgb_19177246_CollaoCallpa(lista.get(i),count); 
            histo.add(colorRgb);
        }
       
        return histo;
    }
   
    public List<HistogramColor_19177246_CollaoCallpa> filterHex(List<String> lista){
        List<HistogramColor_19177246_CollaoCallpa> histo = new ArrayList<>();
 
        for (int i = 0; i < lista.size(); i++){
            int flag = 0;
            int count = 0;

            for (int j = i+1; j < lista.size(); j++){
                if (lista.get(i).equals(lista.get(j))){
                    flag = 1;
                    break;
                }
            }
 
            if (flag == 1)
                continue;

            for (int j = 0;j<=i;j++){
                if (lista.get(i).equals(lista.get(j)))
                    count++;
            }
            HistogramColorHex_19177246_CollaoCallpa colorHex;
            colorHex = new HistogramColorHex_19177246_CollaoCallpa(lista.get(i),count); 
            histo.add(colorHex);
        }
       
        return histo;
    }

    /*  Descripción: rota la imágen 90° a la derecha.  */
    @Override
    public void rotate90() { 
        this.pixels.forEach(pixel -> {
            int newPosX = pixel.getPosY();
            int newPosY = pixel.getPosX();
            pixel.setPosX(newPosX);
            pixel.setPosY(newPosY);
        });  
        this.flipH();
    }

    /*  Descripción: Comprime una imágen eliminando aquellos pixeles con el color más frecuente. La imagen comprimida resultante solo se puede manipular con las otras funciones una vez que haya sido descomprimida a partir de la función señalada más adelante */
    @Override
    public CompressedImage_19177246_CollaoCallpa compress() { 
        List<Integer> listaDepths = new ArrayList<>();
        if(this.isBitmap()){  
            Image_19177246_CollaoCallpa img = new Image_19177246_CollaoCallpa(this.width,this.height, mostFrecuencyColorBitNegativeList());
            this.mostFrecuencyColorBitList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage_19177246_CollaoCallpa cimg = new CompressedImageBit_19177246_CollaoCallpa(img,listaDepths, this.mostRepeatedColorBit());  
            return cimg;
        }else if(this.isPixmap()){
            Image_19177246_CollaoCallpa img = new Image_19177246_CollaoCallpa(this.width,this.height, mostFrecuencyColorRgbNegativeList());
            this.mostFrecuencyColorRgbList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage_19177246_CollaoCallpa cimg = new CompressedImageRgb_19177246_CollaoCallpa(img,listaDepths, this.mostRepeatedColorRgb());  
            return cimg;
        }else{
            Image_19177246_CollaoCallpa img = new Image_19177246_CollaoCallpa(this.width,this.height, mostFrecuencyColorHexNegativeList());
            this.mostFrecuencyColorHexList().forEach(depth -> {
                listaDepths.add(depth.getDepth());
            });
            CompressedImage_19177246_CollaoCallpa cimg = new CompressedImageHex_19177246_CollaoCallpa(img, listaDepths, this.mostRepeatedColorHex());  
            return cimg;
        }
    }
    
    /*  Funcion que recupera el color Bit mas repetido */
    public Integer mostRepeatedColorBit(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor_19177246_CollaoCallpa color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorBit_19177246_CollaoCallpa colorBit = (HistogramColorBit_19177246_CollaoCallpa) color;
        
        return colorBit.getBit();
    }
    
    /*  Funcion que recupera el color RGB mas repetido */
    public List<Integer> mostRepeatedColorRgb(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor_19177246_CollaoCallpa color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorRgb_19177246_CollaoCallpa colorRgb = (HistogramColorRgb_19177246_CollaoCallpa) color;
        
        return colorRgb.getRgb();
    }
    
    /*  Funcion que recupera el color Hex mas repetido */
    public String mostRepeatedColorHex(){
        List<Integer> listaFrecuencia = new ArrayList<Integer>();
        this.histogram().getHisto().forEach(colorHisto -> {
            listaFrecuencia.add(colorHisto.getTimes());
        });
        Collections.sort(listaFrecuencia, Collections.reverseOrder());
        int maxColorTimes = listaFrecuencia.get(0);
        
        HistogramColor_19177246_CollaoCallpa color = this.histogram().getHisto().stream().filter(h -> h.getTimes() == maxColorTimes).toList().get(0);
        HistogramColorHex_19177246_CollaoCallpa colorHex = (HistogramColorHex_19177246_CollaoCallpa) color;
        
        return colorHex.getHex();
    }
    
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorBitList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        int colorMax = this.mostRepeatedColorBit();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return colorMax == ((Pixbit_19177246_CollaoCallpa) pixel).getBit();
        }).toList();
        
        return lista;
         
    }
    
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorBitNegativeList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        int colorMax = this.mostRepeatedColorBit();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return colorMax != ((Pixbit_19177246_CollaoCallpa) pixel).getBit();
        }).toList();
        
        return lista;
        
    }
 
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorRgbList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        List<Integer> colorMax = this.mostRepeatedColorRgb();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return colorMax.equals(((Pixrgb_19177246_CollaoCallpa) pixel).getRGB());
        }).toList();
        
        return lista;
         
    }
    
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorRgbNegativeList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        List<Integer> colorMax = this.mostRepeatedColorRgb();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return !colorMax.equals(((Pixrgb_19177246_CollaoCallpa) pixel).getRGB());
        }).toList();
        
        return lista;
        
    }
     
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorHexList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        String colorMax = this.mostRepeatedColorHex();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return colorMax.equals(((Pixhex_19177246_CollaoCallpa) pixel).getHex());
        }).toList();
        
        return lista;
         
    }
    
    public List<Pixel_19177246_CollaoCallpa> mostFrecuencyColorHexNegativeList(){
        List<Pixel_19177246_CollaoCallpa> lista;
        
        String colorMax = this.mostRepeatedColorHex();
        lista =  (List<Pixel_19177246_CollaoCallpa>) this.pixels.stream().filter(pixel-> {
            return !colorMax.equals(((Pixhex_19177246_CollaoCallpa) pixel).getHex());
        }).toList();
        
        return lista;
        
    }
    

    /*  Descripción: Función que permite obtener el valor del bit opuesto. */
    @Override
    public void invertColorBit() {
        this.pixels.forEach(pixel -> { 
            pixel.invertColor();
        }); 
    }
    
    /*  Descripción: Función que permite obtener el valor del color RGB opuesto. */
    @Override
    public void invertColorRGB() {
        this.pixels.forEach(pixel -> { 
            pixel.invertColor();
        }); 
    }

    /* Descripción: Permite modificar un pixel de la lista pixeles de la imagen  */
    @Override
    public void changePixel(Pixel_19177246_CollaoCallpa p) {
        List<Pixel_19177246_CollaoCallpa> lista = new ArrayList<>();
        this.pixels.forEach(pixel -> { 
            if(pixel.getPosX() == p.getPosX() && pixel.getPosY() == p.getPosY()){
                lista.add(p);
            }else{
                lista.add(pixel);
            }
        }); 
        this.setPixels(lista);   
    }

    /* Descripción: Función que transforma una imagen a una representación string  */
    @Override
    public String toString() { 
        List<String> lista = new ArrayList<>();
        StringBuilder sb;
        sb = new StringBuilder();

        lista.add("\nAncho:"+this.width+", alto: "+this.height+"\n");
        this.pixels.forEach(pixel -> {
           lista.add(pixel.toString());
        });
        
        lista.add(this.histogram().toString());
        lista.forEach(sb::append);
        String concatString = sb.toString();
        
        return concatString;
    }
    
    /* Descripción: Función que permite separar una imágen en capas en base a la profundidad en que se sitúan los pixeles. El resultado consiste en una lista de imágenes donde cada una agrupa los píxeles que se sitúan en el mismo nivel de profundidad. Además, en las imágenes resultantes se sustituyen los píxeles que se encuentran en otro nivel de profundidad por píxeles blancos (255,255,255).  */
    @Override
    public void depthLayers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
