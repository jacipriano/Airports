public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }
    public Time(int time){
        this.minute=time%100;
        this.hour=(time/100);
    }


    /**ESTE ESTÁ MAL!!!!
     *
     * @param dep
     * @param depTZ TIME ZONE DA SAIDA
     * @param arr
     * @param arrTZ TIME ZONE DA CHEGADA
     * @return
     */
    public static int getTime(Time dep,int depTZ, Time arr, int arrTZ){


        return ((arr.hour*60+ arr.minute+arrTZ*60)-(dep.hour*60+ dep.minute+depTZ*60));
    }
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("[%02d:%02d]",hour,minute);
    }
}
