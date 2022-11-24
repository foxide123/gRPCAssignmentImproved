
import com.assignment.client.SlaughterhouseClient;
import com.assignment.protobuf.Animal;
import com.google.protobuf.Descriptors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.util.ArrayList;
import java.util.Map;



@RunWith(JUnit4.class)
public class TestgRPC {

    private SlaughterhouseClient slaughterhouseClient;

    @BeforeEach
    public void setup()
    {
        slaughterhouseClient = new SlaughterhouseClient();
    }

    /*
    @Test
    public void getAnimalByIdTest() throws Exception{
        slaughterhouseClient = new SlaughterhouseClient();
        Animal request = Animal.newBuilder().setRegNr(12345).build();
        Animal expectedAnimal = Animal.newBuilder()
                .setRegNr(12345)
                .setArriveDate("10-02-2022")
                .setWeight(200.56f)
                .setOrigin("Poland")
                .build();
        Map<Descriptors.FieldDescriptor, Object> response = slaughterhouseClient.getAnimalById(request.getRegNr());
        ArrayList<String> animalResponseList = new ArrayList<>();
        response.forEach((type,animalValue) -> {
            animalResponseList.add(animalValue.toString());
        });
        Animal responseAnimal = Animal.newBuilder()
                .setRegNr(Long.parseLong(animalResponseList.get(0)))
                .setArriveDate(animalResponseList.get(1))
                .setWeight(Float.parseFloat(animalResponseList.get(2)))
                .setOrigin(animalResponseList.get(3))
                .build();
        assertEquals(expectedAnimal,responseAnimal);
    }


     */
}
