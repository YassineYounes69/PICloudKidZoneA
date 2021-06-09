package com.example.kidszonea4arctic3.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "restrict_word")
@Component
public class RestrictWord  {

	
	private String word;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "word_seq")
	@SequenceGenerator(name = "word_seq", sequenceName = "word_seq")
	@Column(name="id")
	private Long id;
	public Long getId() {
		return id;
	}

	public RestrictWord() {}
	
	public RestrictWord(String word) {
		super();
		this.word = word;
	}

	@Column(name="word", nullable = false)
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
