<?php

namespace App\Controller;

use App\Entity\Commentaire;
use App\Entity\Signaler;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Doctrine\Persistence\ManagerRegistry;
use Symfony\Component\HttpFoundation\Request;
use App\Repository\SignalerRepository;
use App\Repository\CommentaireRepository;

use App\Form\SignalerType;




class SignalerController extends AbstractController
{
    #[Route('/signaler', name: 'app_signaler')]
    public function index(): Response
    {
        return $this->render('signaler/index.html.twig', [
            'controller_name' => 'SignalerController',
        ]);
    }

    #[Route('/signal/add/{id}', name: 'app_add_signal')]
    public function addSignal($id,Request $request,ManagerRegistry $doctrine,CommentaireRepository $repo,SignalerRepository $repo1): Response
    {   $signal=new Signaler();
        $comment=new Commentaire();

        $comment= $repo->findOneById($id);
        $idUserC = $comment->getIdUtilisateur();
        
        $signal ->setCommentaire($comment);
        $signal ->setUserProp($idUserC);
        $signal ->setUserAction(1);

        //cération du formulaire
        $form=$this->createForm(SignalerType::class,$signal);

        //remplir l'objet a partir du formulaire
        //les getters
        $form->handleRequest($request);

        if($form->isSubmitted() && $form->isValid() ){
            $signal = $form->getData();
            $ch = $signal->getCause();
            if ($ch == NULL) {
                $this->addFlash('error', 'Vous devez inserer une cause');
                return $this->redirectToRoute('app_affiche_classroom');
            }
            //gestionaire
            $em=$doctrine->getManager();
            //ajout
            $em->persist($signal);
            $em->flush();

            $nbr= $repo1->countBySignalC($id);
            if($nbr == 3 ){
                $Commentaire= $repo->find($id);
                $em=$doctrine->getManager();
                    $em->remove($Commentaire);
                    $em->flush();
                    $this->addFlash('error', 'Cet commentaire a été retiré');
                    return $this->redirectToRoute('app_affiche_classroom');
            }


            $this->addFlash('success', 'Votre cause a été ajouté avec succès !');
            return $this->redirectToRoute('app_affiche_classroom');
            //return $this->render('commentaire/essai.html.twig',[
               // 'Comm'=>$comment
            //]);
        }

           //on va envoyer le formulaire a la vue
           return $this->renderForm('signaler/add.html.twig', [
            'myForm' => $form,
        ]);
}


}
