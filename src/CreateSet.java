//Evaluate/draw pixels
public class CreateSet {
    public CreateSet()
    {
        int boundary = 4;
        int countBoundary = 100;
        CreateFrame createFrame = new CreateFrame();
        for(double j = -3.6; j < 1.2; j += 0.001)   //X Value
        {
            for(double k = -1.36; k < 1.36; k += 0.001)   //Y Value
            {
                int count = 0;
                double ca = j; //real part of complex number C
                double cb = k; //imaginary part of complex number C
                double zx = 0; //Real part of Complex number Z0
                double zy = 0; //Imaginary part of complex number Z0
                while (count < countBoundary && ((zx*zx) + (zy*zy)) < boundary) //While Z is bounded
                {
                    count += 1;
                    double xtemp = (zx*zx) - (zy*zy); //Calculate real part of Zn+1 (TEMP)
                    zy = (2*zx*zy) + cb; //Calculate imaginary part of Zn+1
                    zx  = xtemp + ca;//Calculate real part of Zn+1
                }
                int intJ = (int) (j*250) + 900; //Calculate pixels to draw
                int intK = (int) (k*250) + 340;
                if(count == countBoundary) //IF C forms bounded number
                {
                    createFrame.image.setRGB(intJ, intK, 0); //(CENTER COLOUR - BOUNDED - BLACK)

                }
                else if(((zx*zx) + (zy*zy)) > 4 && count < 18 && count > 4) //IF C forms unbounded number
                {
                    createFrame.image.setRGB(intJ, intK, 235+ 45*count); //(BACKGROUND COLOUR - UNBOUNDED - GREEN)
                }
                else if(count >= 18 && count < countBoundary)  //IF C forms unbounded number (with a higher count)
                {
                    createFrame.image.setRGB(intJ, intK, 999 + (count*count)); //()
                }
                else //Outer background (Unbounded)
                {
                    createFrame.image.setRGB(intJ, intK , 20); //Black

                }
            }
        }
        createFrame.constructFrame(); //Draws image onto frame
    }
}

