pattern_author: the creator of the pattern 
  synonyms: creator, pattern_maker, pattern_designer
    author_id: The entry identification of the author as an int value
    name: name of the author of this patter
knitting_patterns: a table of pattern info and links to images
  synonyms: charts, knitting_designs, clothing designs
    pattern_id: The entry identification of the pattern as an int value
    category: the type of object the pattern creates
    needle_size: size of the needle in american and metric
    pattern_link: link to image url that displays picture of image
crochet_patterns: a table of crochet design info
  synonyms: charts, knitting_designs, clothing designs
    pattern_id: The entry identification of the pattern as an int value
    category: the type of object the pattern creates
    hook_size: size of the needle in american and metric
    pattern_link: link to image url that displays picture of image
yarn: table containing yarn info and recommended sizes for patterns
  synonyms: string, fiber, strand, cord, twine, thread
    weight: actual mass times gravity of the yarn in metric and customary
    yardage: length of strands of yarn
    fibers: type of material the yarn is made out of. It could be cotton, alpaca, acrylic, etc.
    recommended_hook_size: recommended by manufacturer size of hook for use in crochet patterns
    recommended_needle_size: recommended by manufacturer size of hook for use in crochet patterns 
----------
knitting_patterns-MadeOf-yarn
  many-many
    for each knitting pattern 
