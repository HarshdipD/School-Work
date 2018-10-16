package lab3;

public class weather {
    
    private int tempF;          //Temp in F
    private int windSpeed;      //Wind speed in mph
    private double windChill;
    //private boolean severe;
    
    public weather()   
    {
        tempF = 0;
        windSpeed = 0;
    }
    
    public weather(int tempF, int windSpeed)
    {
        this();
        setTempF(tempF);
        setWindSpeed(windSpeed);
        setWindChill();
    }
    
    public void setTempF(int tempF)
    {
        if(-50 < tempF && tempF < 150){
            this.tempF = tempF;
         }
    }
    
    public void setWindSpeed(int windSpeed)
    {
        if(windSpeed > 0)
            this.windSpeed = windSpeed;
    }
    
    public void setWindChill()
    {
        double fac = (double)8/50;
        double vel = (double)windSpeed;
        double tem = (double)tempF;
        this.windChill = 35.74 +(0.6215*tem)-(35.75*Math.pow(vel,fac))+ (0.4275*(Math.pow(vel,fac))*tem);
        
    }
     public int getTemp()
        {
                return tempF;
        }

        public int getVel()
        {
                return  windSpeed;
        }

        public double getWindc()
        {
                return windChill;
        }

        public boolean isSevere()
        {
                if(windChill < -15)
                        return true;
                return false;
        }
        public String toString()
        {
                return "Current Temperature is " + tempF + "'F. Feels Like " +
                        Math.round(Math.ceil(windChill*10.0))/10.0 +
                        "'F and Wind Speed is " + windSpeed + " mph";
        }
    
}
