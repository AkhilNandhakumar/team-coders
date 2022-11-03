package com.nighthawk.spring_portfolio.mvc.questions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  // Annotations to simplify writing code (ie constructors, setters)
@NoArgsConstructor
@AllArgsConstructor
@Entity // Annotation to simplify creating an entity, which is a lightweight persistence domain object. Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String question;

	@Column()
	private String content1;

	@Column()
	private String content2;

	@Column()
	private String content3;

	@Column()
	private String code1;
	
	@Column()
	private String code2;

	@Column()
	private String hint;

	@Column()
	private String answer1;

	@Column()
	private String answer2;
	
	@Column()
	private String answer3;

	@Column()
	private String answer4;
	
	@Column()
	private String time;

	@Column()
	private String points;

}