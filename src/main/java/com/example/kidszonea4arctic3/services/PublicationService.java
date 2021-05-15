package com.example.kidszonea4arctic3.services;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectModerationLabelsResult;
import com.amazonaws.services.rekognition.model.DetectTextRequest;
import com.amazonaws.services.rekognition.model.DetectTextResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.ModerationLabel;
import com.amazonaws.services.rekognition.model.TextDetection;
import com.amazonaws.util.IOUtils;
import com.example.kidszonea4arctic3.models.Commentaire;
import com.example.kidszonea4arctic3.models.Likes;
import com.example.kidszonea4arctic3.models.Parent;
import com.example.kidszonea4arctic3.models.Publication;
import com.example.kidszonea4arctic3.models.Report;
import com.example.kidszonea4arctic3.models.ReportPK;
import com.example.kidszonea4arctic3.models.UnhealthyWord;
import com.example.kidszonea4arctic3.repositories.CommentaireRepo;
import com.example.kidszonea4arctic3.repositories.ILikingRepository;
import com.example.kidszonea4arctic3.repositories.IReportRepository;
import com.example.kidszonea4arctic3.repositories.IUnhealthyWordRepository;
import com.example.kidszonea4arctic3.repositories.ParentRepository;
import com.example.kidszonea4arctic3.repositories.PublicationRepository;
import org.springframework.web.multipart.MultipartFile;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils ;

@Service
public class PublicationService implements IPublicationService {
	
	
	@Autowired
	PublicationRepository PublicationRepository;
	@Autowired 
	IReportRepository iReportRepository;
	
	@Autowired 
	IUnhealthyWordRepository iUnhealthyWordRepository;
	@Autowired 
    PublicationService ips ;
	@Autowired 
	ParentRepository pr ;
	@Autowired 
	ILikingRepository iLikingRepository;
	@Autowired
	CommentaireRepo commentaireRepo ;
	private static final Logger L = LogManager.getLogger(IPublicationService.class);



	@Override
	public List<Publication> readAllPublication() {
		List<Publication> liste = (List<Publication>) PublicationRepository.findAll();
	return liste;
	}
	

	
	
	@Override
	public Publication addPublication(Publication p) {
		
		Publication cnt = PublicationRepository.save(p);
		return cnt;
	}
	
	

	@Override
	public Publication updatePublication(Publication p) {
		Publication up = PublicationRepository.save(p) ; 
		return up ;
	}

	@Override
	public void deletePublication (Long id) {
		PublicationRepository.deleteById(id);
	}

	@Override
	public Publication RetrievePublication(long id) {
		L.info("in RetreivePublication id=  " + id);
		Publication p = PublicationRepository.findById(id).get() ; 
		L.info("Publication returned = : " + p );
		return p;
	}


	
	
	@Override
	public long addorupdatepost(Publication pp)
	{
		pp.setDate_pub(LocalDateTime.now());

		PublicationRepository.save(pp);
		return pp.getIdpub(); 
		
	}
	/*
	public String TypeFile(MultipartFile file) throws IOException {
		String fileName = fileStorageServiceImpl.storeFile(file);
		int length = fileName.length();
		String typefile = fileName.substring(length - 3, length);
		if (typefile.equals("png") || typefile.equals("peg") || typefile.equals("jpg")) {
			return "Image";
		} else {
			return "Video";
		}
	}
	

	public String TypeFile(UploadedFile file) throws IOException {
		if(file.getSize()==0){
			return "Nofile";
		}
		else{
		String fileName = fileStorageServiceImpl.UploadImages(file);
		int length = fileName.length();
		String typefile = fileName.substring(length - 3, length);
		if (typefile.equals("png") || typefile.equals("peg") || typefile.equals("jpg")) {
			return "Image";
		} 
		else {
			return "Video";
		}
		}
	}
	public Publication AffecterImageVideoPub(Publication pub, MultipartFile file) throws IOException {
		String fileName = fileStorageServiceImpl.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
				.path(fileName).toUriString();
		String typefile = TypeFile(file);
		if (typefile.equals("Image")) {
			pub.setImage(fileDownloadUri);
		} else {
			pub.setVideo(fileDownloadUri);
		}
		return pub;
	}
	
	
	public Publication UpdatePubWithImage(Publication pub, UploadedFile file) throws IOException, ParseException {
		Publication PubWithImg = AffecterImageVideoPubs(pub, file);
		String typefile = TypeFile(file);
		PublicationRepository.save(PubWithImg);
		
		return PubWithImg ;

	}
	
	public Publication AffecterImageVideoPubs(Publication pub, UploadedFile file) throws IOException {
		String fileName = fileStorageServiceImpl.UploadImages(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
				.path(fileName).toUriString();
		String typefile = TypeFile(file);
		if (typefile.equals("Image")) {
			pub.setImage(fileDownloadUri);
		} else {
			pub.setVideo(fileDownloadUri);
		}
		return pub;
	}

	
	public Publication UpdatePubWithoutImage(Publication pub) throws IOException, ParseException {
		pub.setDate_pub(LocalDateTime.now());

		String typefile;
		if(pub.getType_pub().image!=null){
			 typefile = "Image";
		}
		else{
			 typefile = "Video";
		}

		return PublicationRepository.save(pub);

	}
	
*/

	@Override
	public String addPublicationMsg(Publication p) throws Exception {
		boolean approved=true;
		String msg="";
		long id = 5 ; 
		//p.setParent(currentParent());
		Parent ppp = pr.findById(id).get() ;

	//	Optional<Parent> current = pr.findById((long) 5) ; 

		p.setParent(ppp);

		p.setDate_pub(LocalDateTime.now());
		for(UnhealthyWord uwd : iUnhealthyWordRepository.findAll())
		{
			if (p.getPubContent().toLowerCase().contains(uwd.getWord()))
			{
				approved=false;
				msg+="Sorry, you can't post hate speech or bad words on Keedo.";
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				
	
			}
			
			
		}
			
	
		
				PublicationRepository.save(p);
				return ("post added successfully");
			
			
		
		
	}

	/*
	 * @Override
	public String addPublicationMsg(Publication p) throws Exception {
		boolean approved=true;
		String msg="";
		long id = 5 ; 
		//p.setParent(currentParent());
		Parent ppp = pr.findById(id).get() ;

	//	Optional<Parent> current = pr.findById((long) 5) ; 

		p.setParent(ppp);

		p.setDate_pub(LocalDateTime.now());
		for(UnhealthyWord uwd : iUnhealthyWordRepository.findAll())
		{
			if (p.getPubContent().toLowerCase().contains(uwd.getWord()))
			{
				approved=false;
				msg+="Sorry, you can't post hate speech or bad words on Keedo.";
				
	
			}
			
			if(p.getSrc_pub().toString().equals("image") && detectText(p.getSrc_pub()).toLowerCase().contains(uwd.getWord()))
			{
				approved=false;
				msg+=" You can't upload images that contains hate speech or bad words on Keedo.";
			}
		}
			
			if((p.getType_pub()).toString().equals("image") && detect(p.getSrc_pub()).isEmpty()==false){
				approved=false;
				msg+=" The image you're trying to upload is against our community standards. Our system detected: "+
						detect(p.getSrc_pub())+" labels in this image.";
			}
			if(approved==false){
				return (msg);
			}
			else{
				PublicationRepository.save(p);
				return ("post added successfully");
			}
			
		
		
	}

	 */

	@Override
	public String updatePublicationMsg(Publication p , long id) throws Exception {

		boolean approved=true;
		String msg="";
		long idparent = (long) 5; 
		long idd = 5 ; 
		Parent ppp = pr.findById(idd).get() ;
		p.setParent(ppp);

		
		Publication post = PublicationRepository.findById(id).get();
		
		if(!(idparent== post.getParent().getId()) )
		{
			return("You are not allowed to update this post");

		}
		else
		{
			for(UnhealthyWord uwd : iUnhealthyWordRepository.findAll())
			{
				if (p.getPubContent().toLowerCase().contains(uwd.getWord()))
				{
					approved=false;
					msg+="Sorry, you can't post hate speech or bad words on Keedo.";
					
		
				}
				
				if(p.getType_pub().toString().equals("image") && detectText(p.getSrc_pub()).toLowerCase().contains(uwd.getWord()))
				{
					approved=false;
					msg+=" You can't upload images that contains hate speech or bad words on Keedo.";
				}
			}
				
			
		}
		
		if((p.getType_pub()).toString().equals("image") && detect(p.getSrc_pub()).isEmpty()==false){
			approved=false;
			msg+=" The image you're trying to upload is against our community standards. Our system detected: "+
					detect(p.getSrc_pub())+" labels in this image.";
		}
		if(approved==false){
			return (msg);
		}
		else{
			post.setDate_pub(LocalDateTime.now());
			post.setPubContent(p.getPubContent());
			post.setType_pub(p.getType_pub());
			post.setSrc_pub(p.getSrc_pub());
			PublicationRepository.save(p);
			return ("post updated successfully");
		}		}

	
	
	@Override
	public List<Publication> getALLPublications() throws Exception {
		// TODO Auto-generated method stub
		List<Publication> posts = new ArrayList<Publication>() ;
		PublicationRepository.findAll().forEach(e->posts.add(e));
		return posts ;
		
	}
	

	@Override
	public List<Publication> getMyPublications() throws Exception {
		long id = 5 ; 
		Parent ppp = pr.findById(id).get() ;
		return PublicationRepository.getPostByUserId(ppp.getId()) ;
	}
	
	


	
	@Override
	public long CountPublicationsByUser(long id) {
	//List<Publication> post = new ArrayList<Publication>() ;

	List<Publication> posts = (List<Publication>) PublicationRepository.getPostByUserId(id) ;
	return posts.size() ;
	}

	

	@Override
	public Publication getPublicationById(long id) {
		return PublicationRepository.findById(id).get();
	}

	@Override
	public List<Publication> getPublicationsByUserId(long id) {
		return (List<Publication>) PublicationRepository.getPostByUserId(id) ;
	}


	
	@Override
	public List<String> detect(String photo) throws Exception {
        ByteBuffer imageBytes;
        try (InputStream inputStream = new FileInputStream(new File(photo))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }


        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();

        DetectModerationLabelsRequest request = new DetectModerationLabelsRequest()
                .withImage(new Image().withBytes(imageBytes))
                .withMinConfidence(60F);

            DetectModerationLabelsResult result = rekognitionClient.detectModerationLabels(request);
            List<ModerationLabel> labels = result.getModerationLabels();
            List<String> forbidden = new ArrayList<String>() ; 
            System.out.println("Detected labels for " + photo);
            for (ModerationLabel label : labels)
            {
            forbidden.add(label.getName());
               System.out.println("Label: " + label.getName()
                + "\n Confidence: " + label.getConfidence().toString() + "%"
                + "\n Parent:" + label.getParentName());
           
           }
            System.out.println("forbidden labels detected: "+forbidden);
            return (forbidden);
           }
	
	
	@Override
	public String detectText(String photo) throws Exception {
		 ByteBuffer imageBytes;
	        try (InputStream inputStream = new FileInputStream(new File(photo))) {
	            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
	        }
	        AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.defaultClient();
		      
		      DetectTextRequest request = new DetectTextRequest()
		              .withImage(new Image().withBytes(imageBytes));

		         DetectTextResult result = rekognitionClient.detectText(request);
		         List<TextDetection> textDetections = result.getTextDetections();
		         String detectedtext = "" ; 

		         System.out.println("Detected lines and words for " + photo);
		         for (TextDetection text: textDetections) {
		             detectedtext+=text.getDetectedText();

		                 System.out.println("Detected: " + text.getDetectedText());
		                 System.out.println("Confidence: " + text.getConfidence().toString());
		                 System.out.println("Id : " + text.getId());
		                 System.out.println("Parent Id: " + text.getParentId());
		                 System.out.println("Type: " + text.getType());
		                 System.out.println();
		         }
		            System.out.println("text detected: "+detectedtext);

				return detectedtext;

		   }

	@Override
	public List<Publication> searchPublications(String pattern) {
		
		return PublicationRepository.findPostsByTextContaining(pattern) ;
	}

	@Override
	public List<Publication> searchP(String pattern) {
		List<Publication> l = PublicationRepository.findPostsByTextContaining(pattern) ;
		return l ;
	}
	@Override
	public String sharePublication(long idP) throws Exception {
		long id = 5 ; 
		Parent ppp = pr.findById(id).get() ;
		
		Publication posts = PublicationRepository.findById(idP).get() ;
		Publication newpost = new Publication() ;
		//newp.setUser(currentUser());
		newpost.setParent(ppp);
		newpost.setPubContent(posts.getPubContent());
		newpost.setType_pub(posts.getType_pub());
		newpost.setSrc_pub(posts.getSrc_pub());
		newpost.setDate_pub(posts.getDate_pub());
		newpost.setParent(posts.getParent());
		PublicationRepository.save(newpost);
		
		return("post shared successfully") ;
	}

	@Override
	public String reportPublication(long idP) throws Exception 
	{
		long id = 5 ; 
		Parent ppp = pr.findById(id).get() ;
		Report r = new Report();
		ReportPK reportPK= new ReportPK();
		reportPK.setIdPost(idP);
		//reportPK.setIdParent(currentparent.getId());
		reportPK.setIdParent(ppp.getId());

		r.setReportPK(reportPK);
		r.setReportDate(LocalDateTime.now());
		iReportRepository.save(r);
		return ("Post reported successfully");
	}
	
	
	@Override
	public List<Publication> getReportedPublications() {
		return PublicationRepository.getReportedPosts();
	}

	@Override
	public boolean isReportExists(long idu, long idp) {
		 int count =(int) iReportRepository.isReportExists(idu, idp);
		 if (count==0)
		 {
			return false;
		}
		 else {
			 return true;
		 }
	}

	@Override
	public int CountPublications() {
		List<Publication> posts = (List<Publication>) PublicationRepository.findAll() ;
		return posts.size() ;
	}




	@Override
	public void approveReportedPublication(int idP) {
		iReportRepository.deleteReport(idP);
		
	}




	@Override
	public List<Publication> getPublicationsCommentedByUser(int id) {
		// TODO Auto-generated method stub
		return PublicationRepository.getPostsCommentedByUser(id);
	}




	@Override
	public List<Publication> getPublicationsLikedByUser(int id) {
        return PublicationRepository.getPostsLikedByUser(id) ; 

	}

	@Override
	public Publication mostLikedPublication() throws Exception {
		int max=0;
		Publication mostliked= new Publication();
		for(Publication p: PublicationRepository.findAll()){
			int nblikes=((List<Likes>) iLikingRepository.getLikesByPostId(p.getIdpub())).size();
			if (max<nblikes)
			{
				max=nblikes;
				mostliked=p;
			}
		}
		return mostliked;
	}




	@Override
	public Publication mostCommentedPublication() throws Exception {
		int max=0;
		Publication mostcommented = new Publication() ; 
		for (Publication p : PublicationRepository.findAll())
		{
			int nbcommented = ((List<Commentaire>) commentaireRepo.getCommentsByPostId(p.getIdpub())).size() ;
			if(max<nbcommented)
			{
				max=nbcommented ;
				mostcommented=p;
			}
			
		}
		return mostcommented ;

	}
	
	
	
	//// recherche avancée///////
	@Override
	public Publication advancedSearsh(String motif){
    	
		Publication u = new Publication();
    	if(PublicationRepository.advancedSearchBypubContent(motif)!=null){
    		
    		return PublicationRepository.advancedSearchBypubContent(motif);
    	}else if(PublicationRepository.advancedSearchByTitrePub(motif)!=null){
    		
    		return PublicationRepository.advancedSearchByTitrePub(motif);
    	}
    	
    	
    	return u;
    }

/*
	@Transactional
	public long savePub(Publication p, UploadedFiles files) {
		
	
		 p.setDate_pub(LocalDateTime.now());

		for (UploadedFile f : files.getFiles()) {
         	String newFileName = fileStorageServiceImpl.UploadImages(f);
         	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH).path(newFileName).toUriString();
			p.setImage(fileDownloadUri);
			PublicationRepository.save(p);
		}
		
		 return p.getIdpub();

	
	}

	
	public Publication AddPub(Publication pub, UploadedFile file) throws IOException, ParseException {
		Publication PubWithImg = AffecterImageVideoPubs(pub, file);
		String typefile = TypeFile(file);
		InputStream inputfile = file.getInputStream();
		PublicationRepository.save(PubWithImg);
			
		
		return PubWithImg ;

	}
	
	
	public long AddP(Publication pub, UploadedFile file) throws IOException, ParseException {
		Publication PubWithImg = AffecterImageVideoPubs(pub, file);
		String typefile = TypeFile(file);
		InputStream inputfile = file.getInputStream();
		PublicationRepository.save(PubWithImg);
			
		
		 return pub.getIdpub();

	}
	*/
	public void savePost(MultipartFile file , String content )
	{
		Publication p = new Publication() ;
	    String filename = StringUtils.cleanPath(file.getOriginalFilename());
	    if(filename.contains(".."))
	    {
	    	System.err.println("not .......");
	    }
	    try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));

	    }
	    catch (IOException e) {
	    	e.printStackTrace();
			// TODO: handle exception
		}
	    
		p.setPubContent(content);
		PublicationRepository.save(p) ;
	}

	
	
	}