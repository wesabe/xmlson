XMLSON
======

Because XML is too bulky and JSON has crappy library support.


Dude Did You Just Invent Your Own Object Notation What Is Wrong With You?
-------------------------------------------------------------------------

No way, man. XMLSON isn't an object notation -- it's a stuper-simple object
model which you can use to produce stuper-simple JSON and stuper-simple XML.


But Will It Support Like XSchemaNamespacey Local-URI Extension 23A.4FG?
-----------------------------------------------------------------------

Oh, hells no. XMLSON is not a fancy thing -- it is like a ruler or a crowbar or
a rock with a nice sharp point. It is for doing a simple thing: producing humane
JSON and XML without having to write two whole damn adapters for each thing.


Ok So When You Said Simple Earlier Like What Did You Mean?
----------------------------------------------------------

You only gotta keep track of like three things.

* A document is the top-level deal. It has a name. It has members.
* An array is a list of things. It has a name. It has members. It can be a
  member, but not of itself, because that's stupid.
* An object is a map of things. It has a name. It has properties, which are just
  things -- strings, numbers, booleans, nulls, objects, or arrays -- with names.
  It can be a member, but not of itself because dude we just went over that.


Ok In The Main That Is A Simple Thing But I Bet The Output Looks Like Total Butt
--------------------------------------------------------------------------------

No way. The whole point of keeping it stuper-simple is to make sure the same set
of objects can be used to produce humane JSON and XML.

Take this set of objects:

    XmlsonDocument doc = new XmlsonDocument("recipe");
    
    XmlsonObject info = new XmlsonObject("info");
    info.addProperty("name", "How To Not Cook An Egg");
    info.addProperty("author", "M.F.K. Fisher");
    
    doc.add(info);
    
    XmlsonArray ingredients = new XmlsonArray("ingredients");
    ingredients.add(new XmlsonObject("ingredient").addProperty("name", "1 egg"));
    ingredients.add(new XmlsonObject("ingredient").addProperty("name", "a French dude"));
    
    doc.add(ingredients);

It'll produce this JSON:

    {
        "info": {
            "name": "How To Not Cook An Egg",
            "author": "M.F.K. Fisher"
        },
        "ingredients": [
            {
                "name": "1 egg"
            },
            {
                "name": "a French dude"
            }
        ]
    }

And this XML:

    <?xml version="1.0"?>
    <recipe>
        <info>
            <name>How To Not Cook An Egg</name>
            <author>M.F.K. Fisher</author>
        </info>
        <ingredients>
            <ingredient>
                <name>1 egg</name>
            </ingredient>
            <ingredient>
                <name>a French dude</name>
            </ingredient>
        </ingredients>
    </recipe>

None of these things suck to parse or deal with once parsed.


Well Ok Then I Suppose You Have Convinced Me Of The Merit Of This Thing
-----------------------------------------------------------------------

Good talk.
