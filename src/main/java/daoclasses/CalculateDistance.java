package daoclasses;

	import com.google.maps.DistanceMatrixApi;
	import com.google.maps.DistanceMatrixApiRequest;
	import com.google.maps.GeoApiContext;
	import com.google.maps.model.DistanceMatrix;
	import com.google.maps.model.DistanceMatrixElement;
import com.google.maps.model.DistanceMatrixElementStatus;
import com.google.maps.model.TravelMode;

	public class CalculateDistance {
	    private static final String API_KEY = "AIzaSyBCxSG5nn4nylREjOdkn3Wei8sCMCh6DJE";

	    public static void main(String[] args) {
	        GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();
	        String origin = "New York, NY";
	        String destination = "Los Angeles, CA";
	        
	        try {
	            DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(context)
	                    .origins(origin)
	                    .destinations(destination)
	                    .mode(TravelMode.DRIVING); // You can also use other travel modes like walking, transit, etc.

	            DistanceMatrix distanceMatrix = request.await();
	            DistanceMatrixElement element = distanceMatrix.rows[0].elements[0];
	            if (element.status == DistanceMatrixElementStatus.OK) {
	                System.out.println("Distance: " + element.distance);
	            } else {
	                System.out.println("Unable to calculate distance: " + element.status);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}



