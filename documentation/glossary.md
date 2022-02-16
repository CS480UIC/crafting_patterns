Entities & Attributes
(maxima & minima in parens)
1. pattern_author: the creator of the pattern 
  synonyms: creator, pattern_maker, pattern_designer
    author_id: The entry identification of the author as an int value
    (1-1)(1)
    name: name of the author of this pattern
    (1-1)(1)
2. knitting_pattern: a table of pattern info and links to images
  synonyms: charts, knitting_designs, clothing designs
    pattern_id: The entry identification of the pattern as an int value
    (1-1)(1)
    category: the type of object the pattern creates
    (1-M)(0)
    needle_size: size of the needle in american and metric
    (M-M)(1)
    pattern_link: link to image url that displays picture of image
    (1-1)(1)
3. crochet_pattern: a table of crochet design info
  synonyms: charts, knitting_designs, clothing designs
    pattern_id: The entry identification of the pattern as an int value
    (1-1)(1)
    category: the type of object the pattern creates
    (1-M)(0)
    hook_size: size of the needle in american and metric
    (M-M)(1)
    pattern_link: link to image url that displays picture of image
    (1-1)(1)
4. yarn: table containing yarn info and recommended sizes for patterns
  synonyms: string, fiber, strand, cord, twine, thread
    weight: actual mass times gravity of the yarn in metric and customary
    (M-1)(1)
    yardage: length of strands of yarn
    (M-1)(1)
    fibers: type of material the yarn is made out of. It could be cotton, alpaca, acrylic, etc.
    (M-1)(1)
    recommended_hook_size: recommended by manufacturer size of hook for use in crochet patterns
    (M-M)(1)
    recommended_needle_size: recommended by manufacturer size of hook for use in crochet patterns 
    (M-M)(1)
    
----------

Relationships:
knitting_patterns-made_of-yarn 
Maxima: many-many
Minima: one-one

crochet_patterns-made_of-yarn 
Maxima: many-many
Minima: one-one

pattern_author-writes-knitting_pattern
Maxima: many-many
Minima: one-one

pattern_author-writes-crochet_pattern
Maxima: many-many
Minima: one-one
