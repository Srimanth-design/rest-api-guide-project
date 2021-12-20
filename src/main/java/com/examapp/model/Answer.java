package com.examapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Answer {

    @Id
    @GeneratedValue(generator = "answer_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "answer_seq", sequenceName = "answer_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "answerid")
    private Integer answerId;
    @Column(length = 100)
    private String answer;
    @Column(name = "linecount")
    private int lineCount;
    @Column(name = "spellerror")
    private int spellError;

    public Answer() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @param answer
     * @param lineCount
     * @param spellError
     */
    public Answer(String answer, int lineCount, int spellError) {
        super();
        this.answer = answer;
        this.lineCount = lineCount;
        this.spellError = spellError;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }


    public int getSpellError() {
        return spellError;
    }

    public void setSpellError(int spellError) {
        this.spellError = spellError;
    }

    @Override
    public String toString() {
        return "Answer [answerId=" + answerId + ", answer=" + answer + ", lineCount=" + lineCount + ", spellError=" + spellError + "]";
    }

}
