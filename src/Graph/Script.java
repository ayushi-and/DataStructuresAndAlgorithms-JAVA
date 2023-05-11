package Graph;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Script {

    public static void main(String[] args) throws IOException {
        String csvFile="/Users/Ayushi.Sharma/Downloads/test.csv";


        File file=new File(csvFile);
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        URL url;
        String line;
        br.readLine();
        while ((line=br.readLine()) != null) {
            String[] values = line.split(",");

            String estateUuid=values[1];

            url = new URL("https://nucleus.stanzaliving.com/projectservice/internal/drop/property/"+estateUuid);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "*/*");
//            con.setRequestProperty("cookie", "token=db90b00f-8f71-4f64-b4ec-aac3e5797be8");
            con.setDoOutput(true);

            String jsonInputString="";

            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            try (BufferedReader br4 = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br4.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                String failedCsvFIle ="/Users/Ayushi.Sharma/Downloads/failed.csv";
                String failedEstateUuid = estateUuid;

                try {
                    FileWriter writer = new FileWriter(failedCsvFIle);
                    writer.write(failedEstateUuid);
                    writer.close();
                    System.out.println("Data written to file successfully.");
                }
                catch (IOException ex) {
                    System.out.println("An error occurred while writing to file: " + ex.getMessage());
                }

            }

        }
    }
}
