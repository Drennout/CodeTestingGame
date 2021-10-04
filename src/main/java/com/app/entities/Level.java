package com.app.entities;

import java.io.*;

public class Level {
    private File level;
    private String content;
    private String answer;

    public Level(File level) {
        this.level = level;

        parseLevel();
    }

    public Level(){

    }


    private void parseLevel() {
        try(FileReader rf = new FileReader(level))
        {
            // читаем посимвольно
            BufferedReader reader = new BufferedReader(rf);
            String line = reader.readLine();
            String tag = "";
            String content = "";
            String answer = "";
            while(line != null){
                if (line.equals("<content>")){
                    tag = line;
                    line = reader.readLine();
                }
                else if(line.equals("</content>")){
                    tag = "";
                }
                else if (line.equals("<answer>")){
                    tag = line;
                    line = reader.readLine();
                }
                else if (line.equals("</answer>")){
                    tag = "";
                }

                if(tag.equals("<content>"))
                    content += line + "\n";

                if(tag.equals("<answer>"))
                    answer += line;

                line = reader.readLine();

                setContent(content);
                setAnswer(answer);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public File getLevel() {
        return this.level;
    }

    public void setLevel(File level) {
        this.level = level;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
