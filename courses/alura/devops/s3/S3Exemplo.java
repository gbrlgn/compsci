import com.amazonaws.auth.AWSSTaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Example {

    public static void main(String[] args) {
        String accessKey = "A23HFIASHF5486GDJIOJISH8486JS";
        String secretKey = "0Fshfs98yfsaFSF7558fdsf68sSSF7s8f78SF87";

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3ClientBuilder.standard()
            .withCredentials(
                new AWSSTaticCredentialsProvider(awsCredentials)
            )
            .withRegion(Regions.USA_EAST_1).build();

        System.out.println("Criando bucket...");
        String bucketName = "alura-s3-sdk";
        s3.createBucket(bucketName);

        System.out.println("Listando buckets:");
        List<Bucket> buckets = s3.listBuckets();
        for (bucket : buckets) {
            System.out.println(bucket.getName());
        }

        System.out.println("Enviando objeto...");
        File object = new File("aws.png");
        s3.putObject(bucketName, "amazon_web_services.png", file);

        System.out.println("Listando objetos do bucket:");
        ListObjectRequest objectReq = new ListObjectRequest()
            .withBucketName(bucketName));
        ObjectListing objectList = s3.listObjects(objectReq);
        for (S3ObjectSummary summary : objectList.getObjectSummaries()) {
            System.out.println(
                "*" + summary.getKey() + " - " +
                summary.getSize() + " - " +
                summary.getOwner()
            );
        }

        System.out.println("Deletando objeto...");
        s3.deleteObject(bucketName, "amazon-s3.png");

        System.out.println("Listando objetos do bucket:");
        ListObjectRequest objectReq2 = new ListObjectRequest()
            .withBucketName(bucketName));
        ObjectListing objectList2 = s3.listObjects(objectReq2);
        for (S3ObjectSummary summary2 : objectList.getObjectSummaries()) {
            System.out.println(
                "*" + summary2.getKey() + " - " +
                summary2.getSize() + " - " +
                summary2.getOwner()
            );
        }

        System.out.println("Deletando bucket...");
        s3.deleteBucket(bucketName);
    }
}