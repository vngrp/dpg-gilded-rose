Hi dpg'er,

Thanks for checking the assigment. It was quitte a fun one to code.
It includes 2 solutions, first one follows all requirements. Second one is how I would normally program it. They have their own test file. Looking forward to talking about the solutions together.

Here are some of my thoughts in advance, that I had during the programming

## Things to collaborate on
Some items are not dependent on the sellIn, but have no way to leave it blank. Shall we make it nullable? Int.maxValue? Default of 0 or 100? Multiple things could work here, but currently there is no good value for it. Used 0 for now

Whenever I had the option to write something in idiomatic kotlin, I did. Sometimes I find non idiomatic more readable, like the if/else elvis structure, so in a normal case I would follow team code style or what I find best readable. Now I did it to show I understand idiomatic kotlin code

Definitely up for debate: For solution 2 I *extended* the item class, but didn’t modify anything of the existing item class. Feel like it nicely follows the open-close principle (open for extension, but closed for modification). Tried to do it with extensions functions outside of the item file, but couldn’t add overwritable/open methods

A small benefit of not being able to touch the item class in the first solution was that I had to call the methods on the different items. Making it that I could give them more specific names like increaseOrDropQuality instead of updateQuality. A little bit more DDD stlyle, but it's neglitiable. This benefit is too tiny to me, I would extend the item class, choose solution 2 and have an adult conversation with the goblin to continue in harmony with the team.

Thanks ✌️
