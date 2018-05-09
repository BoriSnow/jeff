/**Programmer:Victoria Gao
  *
  *Class: ICS3U1
  *
  *Culminating activity: Game
**/
import java.io.*;
import hsa.Console;
class lastWish_victoriaGao
{

    public static void start ()  //Start to Village1
    {
	try
	{
	    Console c = new Console ("Last Wish");
	    FileWriter fr = new FileWriter ("player.txt");
	    PrintWriter pw = new PrintWriter (fr);
	    c.println ("You find yourself lying in the middle of a forest, foliage as far as the eye can see." +
		    " The Wishstone... It's all you can remember. The treasure with the power to grant your deepest desire." +
		    "A name surfaces from your memory: this is what people know you as.");
	    String name = c.readString (); //Get player's name
	    c.println ("Your name is " + name + ". Is this correct? Press 'N' to retype.");
	    char confirm = c.readChar ();
	    while (confirm == 'n' || confirm == 'N') //Confirm name
	    {
		c.clear ();
		c.println ("A name surfaces from your memory: this is what people know you as.");
		name = c.readString ();
		c.println ("Your name is " + name + ". Is this correct? Y/N");
		confirm = c.readChar ();
	    }
	    pw.println (name); //Writes name to player file
	    c.println ("You crawl to a nearby pond and peer in. You don't recognize your features, \nbut at a glance you can tell that you're:");
	    c.println ("1. Male\n2. Female"); //Gender selection.
	    int gender = c.readInt ();
	    if (gender == 1)
		pw.println ("Male");
	    if (gender == 2)
		pw.println ("Female");
	    c.println ("Your features speak of:" +  //Race selection
		    "\n1. Human" +
		    "\n2. Elf" +
		    "\n3. Harpy" +
		    "\n4. Griffyn");
	    int species = c.readInt ();
	    if (species == 1) //Writes selected species to player file. This influences how NPCs interact with them.
		pw.println ("Human");
	    if (species == 2)
		pw.println ("Elf");
	    if (species == 3)
		pw.println ("Harpy");
	    if (species == 4)
		pw.println ("Griffyn");
	    c.println ("You're carrying a weapon:" +  //Class(buff) selection
		    "\n1. Sword(Warrior) - Strong and heavy-hitting. They're the front lines of any \narmy." +
		    "\n2. Bow(Hunter) - Swift and sure. They're skilled at archery." +
		    "\n3. Staff(Sorcerer) - Smart and powerful. They use the power of magic to fight" +
		    "\n4. Daggers(Rogue) - Stealthy and agile. They're hard to hit and strike \naccurately.");
	    int specialty = c.readInt ();
	    if (specialty == 1) //Writes class to player file, along with their stats.
	    {
		pw.println ("Warrior");
		pw.println ("150 HP");
		pw.println ("5 DEF");
		pw.println ("4 ATK");
		pw.println ("1 INT");
		pw.println ("2 AGL");
		pw.println ("3 PRE");
		invAdd ();
		invEdit ("0", 1);
	    }
	    if (specialty == 2)
	    {
		pw.println ("Hunter");
		pw.println ("120 HP");
		pw.println ("2 DEF");
		pw.println ("3 ATK");
		pw.println ("3 INT");
		pw.println ("5 AGL");
		pw.println ("6 PRE");
		invEdit ("5", 1);
	    }
	    if (specialty == 3)
	    {
		pw.println ("Sorcerer");
		pw.println ("80 HP");
		pw.println ("1 DEF");
		pw.println ("4 ATK");
		pw.println ("6 INT");
		pw.println ("3 AGL");
		pw.println ("2 PRE");
		invEdit ("10", 1);
	    }
	    if (specialty == 4)
	    {
		pw.println ("Rogue");
		pw.println ("100 HP");
		pw.println ("2 DEF");
		pw.println ("2 ATK");
		pw.println ("3 INT");
		pw.println ("6 AGL");
		pw.println ("5 PRE");
		invEdit ("15", 1);
	    }
	    c.println ("Cupping your hands, you lift water to your mouth and struggle to stand up. \nA cloth bag leans against a nearby tree. \n1. Look in the bag.\n2. Leave it.");
	    int bag = c.readInt ();
	    if (bag == 1)
	    {
		c.println ("There's an unlit torch. There are five glowing shards that hurt your eyes when \nyou look at them. " +
			"A name for them makes its way into your head: Soul shards. \nPerhaps when you have enough of them you can use them for something...");
		pw.println ("Torch x1");
		pw.println ("Soul Shard x5");
	    }
	    if (bag == 2)
	    {
		c.println ("You reconsider. What's in that bag may be the difference beteen life and death..." +
			"\n1. Look in the bag.\n2. Leave.");
		bag = c.readInt ();
		if (bag == 1)
		{
		    c.println ("There's an unlit torch. There are five glowing shards that hurt you eyes when you look at them. " +
			    "A name for them makes its way into your head: Soul shards. Perhaps when you have enough of them you can use them for something...");
		    pw.println ("Torch 1");
		    pw.println ("Soul Shard 5");
		}
		if (bag == 2)
		    c.println ("You weigh your options and decide it isn't worth it to look inside. It could be a trap.\n>Continue...");
		char next = c.getChar ();
	    }
	    c.println ("You hear noises nearby, perhaps the sound of a small mammal enjoying its food. \nIt would make a good meal for later." +
		    "\n1. Fight\n2. Spare it");
	    int critter1 = c.readInt ();
	    if (critter1 == 1)
	    {
		c.println ("You try to sneak up on it from behind, but it notices you.");
		critterFight (1);
	    }
	    if (critter1 == 2)
	    {
		double chance = roll (5);
		if (chance == 1)
		{
		    c.println ("The critter hears you walking and jumps at you, angry that you disturbed its meal.");
		    critterFight (1);
		}
		else
		{
		    c.println ("The critter hears you walking and runs away, chittering as it does so.");
		}
	    }
	    String noise[] = {
		"screech",
		"scream",
		"howl",
		"chitter"
		};
	    String object[] = {
		"tree",
		"bush",
		"rock",
		"patch of grass",
		"burrow",
		};
	    String adj[] = {
		"rickety old",
		"sketchy",
		"flimsy-looking",
		"dilapidated"
		};
	    int sound;
	    int thing;
	    int desc;
	    for (int i = 0 ; i < 5 ; i++)
	    {
		double rand = roll (7);
		if (rand == 1)
		{
		    sound = (int) roll (3);
		    thing = (int) roll (4);
		    c.println ("You stumble along what you think is a path. A loud" + noise [sound] + " can be heard from a nearby " + object [thing]);
		}
		if (rand == 2)
		{
		    sound = (int) roll (3);
		    c.println ("A piercing " + noise [sound] + " gives you a mini heart-attack. You being to walk faster, hoping that you never meet whatever made that sound.");
		}
		if (rand == 3)
		{
		    thing = (int) roll (4);
		    c.println ("Something leaps at you from a " + object [thing]);
		}
		if (rand == 4)
		{
		    c.println ("You see something moving in the distance.");
		}
		if (rand == 5)
		{
		    c.println ("The 'path' you've been following suddenly ends. Oh, look. Something has been waiting for you at the end.");
		}
		if (rand == 6)
		{
		    c.println ("The path splits off into two.\n1. Go Left.\n2. Go Right.");
		    int path = c.readInt ();
		}
		if (rand == 7)
		{
		    desc = (int) roll (3);
		    c.println ("You cross a " + adj [desc] + " bridge. It sways with each step, which is totally not scary...");
		}
	    }
	    c.println ("There's a village up ahead. You can't remember much about it.");
	    double vilType = roll (4);
	    pw.close ();
	    village (vilType);
	    paths ();
	}
	catch (java.io.IOException e)
	{
	}
    }


    public static void paths ()
    {
    Console c = new Console ("The Journey");
	c.println ("Arc 2: The Journey");
    }


    public static void village (double vilType)
    {
	int choose1;
	if (vilType == 1)
	{
	    c.println ("As you get closer, the sounds of a blacksmith can be heard, loud metallic banging resonating through the air. You can buy equipment here.");
	    c.println ("1. Shop\n2. Leave");
	    choose1 = c.readInt ();
	    if (choose1 == 1)
	    {
		c.clear();
		
	    }
	    if (choose1 == 2)
	    {

	    }
	}
	if (vilType == 2)
	{
	    c.println ("The village is lively, the aroma of delectable food in the air. Merchants display their fresh produce in front of their stores. You can fill up on food here.");
	    c.println ("1. Shop\n2. Leave");
	    choose1 = c.readInt ();
	    if (choose1 == 1)
	    {

	    }
	    if (choose1 == 2)
	    {

	    }
	}
	if (vilType == 3)
	{
	    c.println ("There is magic all around you. Children run around chasing each other with flames in their hands. You can buy potions here.");
	    c.println ("1. Shop\n2. Leave");
	    choose1 = c.readInt ();
	    if (choose1 == 1)
	    {

	    }
	    if (choose1 == 2)
	    {

	    }
	}
	if (vilType == 4)
	{
	    c.println ("No one is here. Objects lay scatered around. Loot here is plentiful but so are the monsters.");
	    c.println ("1. Shop\n2. Leave");
	    choose1 = c.readInt ();
	    if (choose1 == 1)
	    {

	    }
	    if (choose1 == 2)
	    {

	    }
	}
	return;
    }


    public static double roll (int face)
    {
	double num = Math.floor (Math.random () * face) + 1;
	return num;
    }


    public static void critterFight (int num)
    {
	FileReader fr = new FileReader ("");
    }


    public static void monsterFight (int num)
    {

    }

    public static void bossFight (int num)
    {
    
    }

    public static void invAdd ()
    {
	try
	{
	    FileWriter fw = new FileWriter ("inventory.txt");
	    PrintWriter pw = new PrintWriter (fw);
	    for (int i = 0 ; i < 72 ; i++)
	    {
		pw.println (i + ",0");
	    }
	    pw.close ();
	}
	catch (java.io.IOException e)
	{
	}
	return;
    }


    public static void invEdit (String itemID, int quantity)
    {
	try
	{
	    FileReader fr = new FileReader ("inventory.txt");
	    FileWriter fw = new FileWriter ("inventory.txt");
	    BufferedReader br = new BufferedReader (fr);
	    PrintWriter pw = new PrintWriter (fw);
	    String item;
	    for (int i = 0 ; i < 72 ; i++)
	    {
		item = br.readLine ();
		String itemarray[] = item.split (",");
		if (itemID.equals (itemarray [0]))
		{
		    itemarray [1] += quantity;
		}
	    }
	}
	catch (java.io.IOException e)
	{
	}
	return;
    }


    public static void main (String[] args)
    {
	Console c = new Console ("Last Wish");
	c.println ("********************************************************************************");
	c.println ("*                                                                              *");
	c.println ("*                                The Last Wish                                 *");
	c.println ("*                                      ~                                       *");
	c.println ("*                               A Text-Based RPG                               *");
	c.println ("*                                                                              *");
	c.println ("********************************************************************************");
	c.println ("\n              1. Start Game                       2.Exit Game                 \n");
	int sel = c.readInt ();
	do
	{
	    if (sel == 1)
	    {
		c.clear ();
		start ();
	    }
	    if (sel == 2)
		System.exit (0);
	    else
	    {
		c.println ("Invalid selection. Please select either 1 or 2.");
		sel = c.readInt ();
	    }
	}
	while (sel != 1 || sel != 2);

    }


    /*Pseudocode
    - Fighting method
    - Loot method
    - Storing character info method
    - Method for each arc
    Assets
    - Monster select
    - Player files
    */



}
