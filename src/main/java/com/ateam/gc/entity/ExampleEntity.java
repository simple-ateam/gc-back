package com.ateam.gc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TB_EXAMPLE")
public class ExampleEntity {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long num;
	@Column
	private String siteGubun;
	@Column
	private String title;
	@Column
	private String price;
	@Column
	private String link;
	@Column
	private String originImg;
	@Column
	private String createdAt;
	@Column
	private String itemSeq;
}
