package drone.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class GeneralService {

	public String getDateTimeStampShortMonth(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int day = cal.get(Calendar.DATE);

		if (!((day > 10) && (day < 19)))
			switch (day % 10) {
			case 1:
				return new SimpleDateFormat("dd'st' MMM yyyy hh:mm a").format(date);

			case 2:
				return new SimpleDateFormat("dd'nd' MMM yyyy hh:mm a").format(date);

			case 3:
				return new SimpleDateFormat("dd'rd' MMM yyyy hh:mm a").format(date);

			default:
				return new SimpleDateFormat("dd'th' MMM yyyy hh:mm a").format(date);
			}

		return new SimpleDateFormat("dd'th' MMM yyyy hh:mm a").format(date);
	}

}
