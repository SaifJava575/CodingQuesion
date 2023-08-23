package com.nt.matrix;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

public class JPEGCompressionExample {
    public static void main(String[] args) {
        String inputImagePath ="D:\\SaifuddinWorkSpace\\CompressFile\\download.jpg";
        String outputImagePath = "D:\\SaifuddinWorkSpace\\CompressFile\\downloadCompress.jpg";
        
        File inputFile = new File(inputImagePath);
        File outputFile = new File(outputImagePath);
        
        try {
            BufferedImage image = ImageIO.read(inputFile);
            
            // Get the appropriate ImageWriter
            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            
            // Set compression parameters
            ImageWriteParam param = new JPEGImageWriteParam(null);
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.1f); // Set desired compression quality
            
            // Create output stream
            ImageOutputStream outputStream = ImageIO.createImageOutputStream(outputFile);
            writer.setOutput(outputStream);
            
            // Write the image with compression
            writer.write(null, new javax.imageio.IIOImage(image, null, null), param);
            
            // Clean up resources
            outputStream.close();
            writer.dispose();
            
            System.out.println("Image compression complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
