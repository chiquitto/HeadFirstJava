package quizCard;

class QuizCard {
    private String question;
    private String answer;
    
    public QuizCard(){}
    public QuizCard(String q, String a){
        question = q;
        answer = a;
   } 
    public void setQuestion(String q){
        question = q;
    }
    public void setAnswer(String a){
        answer = a;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }
}