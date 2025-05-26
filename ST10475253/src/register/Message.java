/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package register;
import java.util.Scanner;
import java.util.regex.Pattern;
import static register.homepage.setDefaultLookAndFeelDecorated;
import java.util.ArrayList;
import java.util.List;




public class Message {
    private long messageId;
    private int numberSent;
    private String recipient;
    private String text;
    private String hash;
    private static int totalSent = 0;
    private static List<Message> SentMessages = new ArrayList<>();
    
    
    
    
    

    public Message(long messageId, int numberSent, String recipient, String text, String hash) {
        this.messageId = messageId;
        this.numberSent = numberSent;
        this.recipient = recipient;
        this.text = text;
        this.hash = hash;
       
       
    }

    // getters and setters omitted for brevity
    
    
    public boolean checkMessageId()
    {
        return String.valueOf(this.messageId).length()<=10;
    }
    public int checkRecipientCell()
    {
        if (this.recipient !=null && this.recipient.startsWith("+27") && this.recipient.length()>=13)
        {
           return 1;
        }
        return 2;
    }
    
    public String createMessageHash()
    {
        String messageIdStr= String.valueOf(this.messageId);
        String firstTwoDigits=messageIdStr.substring(0,Math.min(2,messageIdStr.length()));
        
        String[]words=this.text.split("\\s+");
        String firstWord=words.length>0?words[0]:"";
        String lastWord=words.length>1?words[words.length-1] : firstWord;
        
        this.hash=firstTwoDigits+":"+this.numberSent+":"+firstWord+lastWord;
        return this.hash;
        
    }
    public String sentMessage(int messageOption)
    {
        switch(messageOption)
        {
            case 1:totalSent++;
                   this.numberSent++;
                   this.sentMessage(messageOption);
                   return"Message Sent";
            case 2:return"Message Disregarded";
            case 3:return"message stored";
            default:return"invalid choice";
            
        }
    }
    public static String printMessage()
    {
        StringBuilder  sb=new StringBuilder();
        sb.append("All Sent Messages:\n");
        for(Message msg : SentMessages)
        {
            sb.append("ID: ").append(msg.messageId)
                    .append("TO: ").append(msg.recipient)
                    .append("text: ").append(msg.text)
                    .append("Hash: ").append(msg.hash)
                    .append("\n");
        }
        return sb.toString();
    }
    public static int returnTotalMessages()
    {
        return totalSent;
    }
    
    public void setRecient(String recipient)
    {
        this.recipient=recipient;
    }
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    public String getHash()
    {
        return hash;
    }
    public void setHash(String hash)
    {
        this.hash = hash;
    }
    
    
        
    }
        
            
   
    


