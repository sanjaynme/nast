package np.edu.nast.demoapp.demoapp.contracts;

/**
 * Created on 13/11/2017.
 *
 * @author Sanjay Tamata
 */

public class AppContract {
    private AppContract() {
    }

    public class Actions {
        public static final String TOKEN_REFRESH_FAILED = "au.com.carecareers.android.token_refresh_failed";
        public static final String NOTIFICATION_RECEIVED = "au.com.carecareers.android.notification_received";
    }

    public class Preferences {
        public final static String IS_LOGGED_IN = "is_logged_in";
        public final static String FIRST_NAME = "first_name";
        public final static String LAST_NAME = "last_name";
        public final static String EMAIL = "email";

    }

    public static class Extras {
        public final static String DATA = "data";
    }


    public class ClientCredentials {
        /* Test server
        public final static String CLIENT_ID = "86e84f17-3fe0-4d3a-a2fd-a93af9ff3355";
        public final static String CLIENT_SECRET = "nxKQWgERJy9ALyDjGEp4bRw4";*/
        public final static String CLIENT_ID = "c7356cc5-aa17-4464-a8bc-c00530994f9a";
        public final static String CLIENT_SECRET = "p4bEWxKgJw4ynER9QALyDjRG";
    }

    public class Errors {
        public static final String IMAGE_ERROR = "Image not found";
    }

    public class Permission {
        public static final int CAMERA = 0;
        public static final int GALLERY = 1;
        public static final int LOCATION = 2;
        public static final int CALL_PHONE = 3;
    }

    public class RequestCode {
        public static final int CAMERA = 100;
        public static final int GALLERY = 101;
        public static final int FILES = 102;

        public static final int PREFERRED_LOCATION = 201;
        public static final int SELECT_AVATAR = 202;
        public static final int LOCATION_AREA = 203;
        public static final int PROFESSION_ROLE = 204;
        public static final int WORK_TYPE = 205;
        public static final int AVAILABILITY = 206;
        public static final int ADD_EDUCATION = 207;
        public static final int COUNTRY = 208;
        public static final int ADD_EMPLOYMENT = 209;
        public static final int WRITE_COVER_LETTER = 210;
        public static final int UPLOAD_FILE = 211;


        public static final int PROFILE_SETUP = 212;
        public static final int EDUCATION_LIST = 213;
        public static final int EMPLOYMENT_LIST = 214;
        public static final int FILE_LIST = 215;
        public static final int PEOPLE_SEARCH = 216;

        public static final int ADVERTISER = 217;
        public static final int JOBALERT = 218;
    }


    public class ActiveStatus {
        public static final int NOT_ACTIVE = 0;
        public static final int ACTIVE = 1;
    }
}
