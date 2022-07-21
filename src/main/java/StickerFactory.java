import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class StickerFactory {

    public static void generate(InputStream inputStream, String fileName) throws Exception{

        //InputStream inputStream = new FileInputStream(new File("src/main/java/img/filme.jpg"));
        //InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();

        // leitura da imagem
        BufferedImage imageFrom = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int imageWidth = imageFrom.getWidth();
        int imageHeight = imageFrom.getHeight();
        int newHeight = imageHeight + 200;
        BufferedImage newImage = new BufferedImage(imageWidth, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem(em memória)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(imageFrom, 0, 0, null);

        // configurar a fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(font);


        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, newHeight - 100);


        // escrever a nova imagem em um arquivo
        ImageIO.write(newImage, "png", new File("src/main/java/img/out/" + fileName));

    }

}
