1. Open cmd from the folder of this project.

2. type : gcloud builds submit --tag gcr.io/[project-id]/index then wait

3. type : gcloud run deploy --image gcr.io/[project-id]/index --platform managed

4. name the service then wait.

5. The cmd will give the service link.
