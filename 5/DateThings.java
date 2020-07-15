String to Date
______________

String date="2017-09-16";  //mystring
DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date mydate = dateformat.parse(date);

##############################################################################################################################


Add/sub days (30) from date
__________________

Date date = new Date();
long thirtydays= 1000L * 60L * 60L * 24L * 30 ; // 30 days in millisecs.
date.setTime(date.getTime()-(thirtydays)); 

##############################################################################################################################

Date to reqd. tring format
_______________________________


Date inputDate;

String dateString = null;
SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
   /*you can also use DateFormat reference instead of SimpleDateFormat 
    * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
    */
dateString = sdfr.format(inputDate);
System.out.println(dateString);
 
 ##############################################################################################################################
