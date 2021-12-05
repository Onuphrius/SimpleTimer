class timer extends Thread
{
    String time;
    long startTimeMillis;
    long endTimeMillis;

    public timer(String name, String time)
    {
        try {
            this.setName(name);
            this.time = time;
        }catch (Exception e){
            System.out.print("An error occurred");
        }
    }
    @Override
    public void run()
    {
        try {
            this.startTimeMillis = System.currentTimeMillis();
            this.endTimeMillis = this.startTimeMillis;
            this.endTimeMillis += parseTimeToSeconds(this.time) * 1000L;
            System.out.println("Um "+formatTime(this.endTimeMillis)+" ist der Timer \""+this.getName()+"\" fertig.");
            while(System.currentTimeMillis() < this.endTimeMillis)
            {
            }
            System.out.println("Der Timer \""+this.getName()+"\" ist fertig.");
            java.awt.Toolkit.getDefaultToolkit().beep();
            main.main(null);
        }catch (Exception e){
            System.out.print(e);
        }
    }

    public String formatTime(long ms)
    {
            long hours = ms / 1000 / 3600 % 24;
            long minutes = ms / 1000 / 60 % 60;
            long seconds = ms / 1000 % 60;
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public int parseTimeToSeconds(String timeString)
    {
        String[] parts = timeString.split(":");

        int min = Integer.parseInt(parts[0]);
        int len = parts[1].indexOf(" ");
        if(len == -1) len = parts[1].length();
        int sec = Integer.parseInt(parts[1].substring(0, len));
        return min*60+sec;
    }
}