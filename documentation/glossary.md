Glossary
Entities & Attributes (maxima & minima in parens)

pattern_author: the creator of the pattern
  synonyms: creator, pattern_maker, pattern_designer 
  Attributes:
    author_id : The entry identification of the author as an int value (1-1)(1) (PK) (INT)
    full_name: name of the author of this pattern (1-1)(1) VARCHAR(45)
    language : the language the pattern is written in (1-1)(0) VARCHAR(45)
 
knitting_pattern: a table of pattern info and links to images 
	synonyms: charts, knitting_designs, clothing designs 
  Attributes:
    pattern_link: link to image url that displays picture of image (1-1)(1) (NOT NULL) VARCHAR(45)
    Pattern_id: The entry identification of the pattern as an int value (1-1)(1) (PK) INT
    needle_size: size of the needle in american and metric (M-M)(1) INT
    category: what type of garment/item the pattern creates (1-1)(1) VARCHAR(45)
    yarn_id: the id of the recommended yarn (FK) VARCHAR(45)
 
crochet_pattern: a table of crochet design info 
  synonyms: charts, knitting_designs, clothing designs 
  Attributes:
    pattern_id: The entry identification of the pattern as an int value (1-1)(1) VARCHAR(45) 
    category: the type of object the pattern creates (1-M)(0) 
    hook_size: size of the needle in american or metric (M-M)(1) DOUBLE
    pattern_link: link to image url that displays picture of image (1-1)(1) VARCHAR(45)
    pattern_author: the author of the pattern (1-1)(1) (FK) VARCHAR(45)
 
yarn: table containing yarn info and recommended sizes for patterns 
  synonyms: string, fiber, strand, cord, twine, thread 
  Attributes:
    yarn_id: unique identifier within table (1-1)(1) (PK) INT
    weight: thickness of the yarn (M-1)(1) INT NOT NULL
    yardage: length of strands of yarn (M-1)(1) INT
    fiber: type of material the yarn is made out of. It could be cotton, alpaca, acrylic, etc. (M-1)(1) VARCHAR(45)
    recommended_hook_size: recommended by manufacturer size of hook for use in crochet patterns (M-M)(1) DOUBLE
    recommended_needle_size: recommended by manufacturer size of hook for use in crochet patterns (M-M)(1) DOUBLE
    name: the name the manufacturer gives the yarn (1-1)(1) VARCHAR(45)
    manufacturer: the company that makes the yarn (1-1)(1) VARCHAR(45)

Relationships: 
  knitting_patterns-made_of-yarn Maxima: many-many Minima: one-one 
    ON DELETE SET NULL
    ON UPDATE CASCADE
  crochet_patterns-made_of-yarn Maxima: many-many Minima: one-one
    ON DELETE SET NULL
    ON UPDATE CASCADE
  pattern_author-writes-knitting_pattern Maxima: many-many Minima: one-one
    ON DELETE SET NULL
    ON UPDATE CASCADE
  pattern_author-writes-crochet_pattern Maxima: many-many Minima: one-one
    ON DELETE SET NULL
    ON UPDATE CASCADE

