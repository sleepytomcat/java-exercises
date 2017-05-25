public class Break {
    public static void main(String[] args) {
	int i = 1;
	switch(i) {
	    case 0:
		System.out.println("i is zero");
		break;
	    case 1:
	    case 2:
		System.out.println("i is one or two");
		break;
	    default:
		System.out.println("i has some unexpected value");
	}

	fromHere: {
	    System.out.println("breakng out from code block");
	    {
		if (i == 1)
		    break fromHere; // note: breaking from both inner and outer blocks
		System.out.println("you'll never see this text");
	    }

	    System.out.println("will never see this text, too");
	}
	
	for (int c = 0; c < 1000; ++c)
	{
	    break; // breaking from loop
	}

	fromHereToo: for(int k = 0; k < 1000; ++k) {
			 for(int l = 0; l < 1000; ++l) {
			    System.out.println("k is " + k + ", l is " + l);
			    if (l > 3)
				break fromHereToo; // breaking from inner for loop
			 }
	}
	
	finalBreak: while (true) {
	    break finalBreak;
	}
    }
}

